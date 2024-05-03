import { createStore as _createStore } from 'vuex';
import axios from 'axios';
import CastleService from '../services/CastleService';
export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      castleList: [],
      castle: {},
      visitList: [],
      visit: {},
    },


    actions: {
      getAllCastles(context) {
        CastleService.listCastles().then(response => {
          context.commit('SET_CASTLELIST', response.data);
        })
          .catch(err => console.error(err));
      },



      getVisitsByDate(context, visitDate) {
        console.log('getVisitsByDate: ' + visitDate);
        CastleService.getVisitsByDate(visitDate).then(response => {
          context.commit('SET_VISITLIST', response.data);
        })
          .catch(err => console.error(err));
      },

    
      deleteVisitsById(context, visitId) {
        CastleService.deleteVisitsById(visitId).then(response => {
          console.log('localStorage.visitDate ' + localStorage.visitDate);
          context.commit('SET_VISITLIST', localStorage.visitDate);
        })
          .catch(err => console.error(err));
      },
      


      
      searchForCastle(context, searchTerms) {
        CastleService.searchForCastles(searchTerms.name)
          .then(response => {
            context.commit('SET_CASTLELIST', response.data);
          })
          .catch(err => console.error(err));
      },
      createVisit(context, visit) {
        CastleService.createVisit(visit)
          .then(response => {
            context.commit('SET_VISIT', response.data);
          })
          .catch(err => console.error(err));
      },
      filterByRegion(context, searchTerms) {
        CastleService.filterByRegion(searchTerms.region)
          .then(response => {
            context.commit('SET_CASTLELIST', response.data);
          })
          .catch(err => console.error(err));
      },
      getCastleDetails(context, castleId) {
        CastleService.getCastleById(castleId).then(response => {
          context.commit('SET_CASTLE', response.data);
        })
          .catch(err => console.error(err));
      },
      getCastlePictures(context, castleId) {
        CastleService.getImagesByCastleId(castleId).then(response => {
          context.commit('SET_CASTLE_IMAGES', response.data);
        })
          .catch(err => console.error(err));



      },
    },


    mutations: {
      SET_CASTLELIST(state, castles) {
        state.castleList = castles;
      },
      SET_VISIT(state, visit) {
        state.visit = visit;
      },
      SET_VISITLIST(state, visits) {

        state.visitList = visits;
      },


      SET_CASTLE(state, castle) {
        state.castle = castle;
      },
      SET_CASTLE_IMAGES(state, images) {
        state.castle.images = images;
      },
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        console.log('set_auth_token: ' + currentUser);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      },
      SET_USER(state, user) {
        state.user = user;
        console.log('SET_USER: ' + currentUser);
        localStorage.setItem('user', JSON.stringify(user));
        console.log(user);
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
      },
    },
    getters: {
      getVisitByDate(state) {
        return state.visit.filter(visit => visit)
      }
    }
  });
  return store;
}