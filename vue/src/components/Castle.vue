<template>
  <div>
    <div class="cardplus">
      <router-link :to="{ name: 'castleDetail', params: { castleId: castle.castleId } }" class="castle-card">
        <div class="castle-card-body">
          <img class="castle-image" :src="castle.castleBannerPhoto" alt="bannerPhoto">
          <div class="castle-content">
            <h5 class="castle-name">{{ castle.castleName }}</h5>
            <p class="castle-desc">{{ castle.shortDesc }}</p>
            <p class="castle-region"><small>{{ castle.region }}</small></p>
          </div>
        </div>
      </router-link>
      <i class="pi pi-plus-circle" v-if="isAuthenticated"  @click="toggleCalendar" ></i> 
     

      <div v-show="showMenu" class="calendar-container">
        <div class="card flex justify-content-center">
          <Calendar v-model="visit.visitDate" inline class="Calendar" @click="createVisit()"> </Calendar>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { ref } from 'vue';
import { useStore } from 'vuex';
import AuthService from '../services/AuthService';
import CastleService from '../services/CastleService';

const date = ref();
export default {
  computed: {
        isAuthenticated() {
            return !!this.$store.state.token ;
        },
  },
  props: ['castle'],
  setup() {
    const showMenu = ref(false);
    const toggleCalendar = () => {
      showMenu.value = !showMenu.value;
    }
    return { showMenu, toggleCalendar };
  },
  
  data() {
    return {
      visit: {
        visitDate: '',
        castleId: '',
        username: ''
      },

    }
  },
  methods: {
    createVisit() {
      // castle ID
      this.visit.castleId = this.castle.castleId;

      //date attempts :(
      const aDate = new Date(this.visit.visitDate);
      this.visit.visitDate = aDate.toISOString(); 
      console.log(this.visit);
      // user ID efforts? :(
      this.visit.username = this.$store.state.user.username;
      this.$store.dispatch('createVisit', this.visit);
    },
  }
}
</script>

<style scoped>
.castle-card {
  display: block;
  max-width: 20rem; 
  height: 30rem; 
  background-color: #8bbab1;
  border: 1.5px solid #193144;
  border-radius: 20px;
  overflow: hidden;
  text-decoration: none;
  font-size: 1.4rem;
  color: inherit;
  transition: transform 0.15s;
  /* affects how fast the scale is on hover */
  box-shadow: 7px 10px 15px rgba(0, 0, 0, 0.4);
}

.castle-card:hover {
  transform: scale(1.015);  
}

.castle-card-body {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.castle-image {
  aspect-ratio: 1/1.1;
  width: 100%;
  height: 100%;
  object-fit: cover;
  overflow: hidden;
  border-radius: 10px;
  margin-bottom: 0px;
  border-bottom: solid 1.5px black;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.3);
}

.castle-content {
  flex: 1;
  width: 100%;
  padding-top: 1.2rem;
}

.castle-name,
.castle-desc,
.castle-region {
  margin: 0rem;
  text-align: center;
  color: white;


}

.castle-desc {
  font-size: .8em; 
  text-shadow: 1px 1px 2px black;
 
}

.castle-name {
  font-size: 1.5rem;
  text-shadow: 1px 1px 2px black;

}

.castle-region small {
  color: #555b61;
  font-size: .8em;
}

.pi-plus-circle {
margin-top: .5rem;
font-size: 1.5rem;
display: flex;
justify-content: end;
padding: 10px;
opacity: 75%;
}

.pi-plus-circle:hover {
  opacity: 100%;
}

.calendar-container {
  position: relative;
  left: 0;
  background-color: #FFFDF1;
  border-radius: 30px;
  padding: 10px;
  margin-bottom: 20px;
}

.cardplus {
  margin-bottom: 3.2rem;
  /* this changes margin on bottom of cards */
}

.card {
  display: flex;
  justify-content: center;
  padding: 1rem;
  height: auto;
  border: none;
  background-color: #FFFDF1;
}
</style>
