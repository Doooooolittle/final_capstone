import axios from 'axios';
export default {
    listCastles() {
        return axios.get('/castles');
    },
    getVisitsByDate(visitDate) {
        return axios.get('/itinerary/'+ visitDate);
    },

    deleteVisitsById(visitId) {
        return axios.delete('/visit/'+ visitId);
    },

    
    searchForCastles(name) {
        let url = '/castle/search/';
        if (name) {
            if (name.toLowerCase().includes('castle')) {
                name = name.toLowerCase().replace('castle', '');
            }
            if (name.toLowerCase().includes('castl')) {
                name = name.toLowerCase().replace('castl', '');
            }
            if (name.toLowerCase().includes('cast')) {
                name = name.toLowerCase().replace('cast', '');
            }
            if (name.toLowerCase().includes('cas')) {
                name = name.toLowerCase().replace('cas', '');
            }
            if (name.toLowerCase().includes('ca')) {
                name = name.toLowerCase().replace('ca', '');
            }
            if (name.toLowerCase().includes('c')) {
                name = name.toLowerCase().replace('c', '');
            }
            url += name.toLowerCase().replace(/\s/g, '');
        } else {
            return axios.get('/castles');
        }
        return axios.get(url);
    },
    filterByRegion(region) {
        let url = '/castle/filter/'
        if (region) {
            url += region;
        }
        return axios.get(url);
    },
    getCastleById(castleId) {
        return axios.get(`/castle/${castleId}`);
    },
    getImagesByCastleId(castleId) {
        return axios.get(`/images/${castleId}`);
    },

    createVisit(visit) {
        let url = '/add/visit'
        return axios.post(url, visit)
        .then(response => console.log(response))
        .catch(error => console.error(error));
    }
}
