<template>
  <div class="main-container">

    <body @onload="loadToday()"></body>
    <div class="calendar-container">
      <div class="calendar">
        <Calendar v-model="visit.visitDate" inline class="Calendar" @click="getItinerary()"
          style="width: 40vw; ">
          
        </Calendar>
      </div>
    </div>
    <div class="list-cont">
      <h2 class="itinerary-name">{{this.$store.state.user.username}}'s Itinerary</h2>
      <VisitList />
    </div>
    <div class="icon-container">
      <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-up"
        type="button" viewBox="0 0 16 16">
        <path fill-rule="evenodd"
          d="M3.5 6a.5.5 0 0 0-.5.5v8a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5v-8a.5.5 0 0 0-.5-.5h-2a.5.5 0 0 1 0-1h2A1.5 1.5 0 0 1 14 6.5v8a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 14.5v-8A1.5 1.5 0 0 1 3.5 5h2a.5.5 0 0 1 0 1z" />
        <path fill-rule="evenodd"
          d="M7.646.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1-.708.708L8.5 1.707V10.5a.5.5 0 0 1-1 0V1.707L5.354 3.854a.5.5 0 1 1-.708-.708z" />
      </svg>
      <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-envelope-open"
        type="button" viewBox="0 0 16 16">
        <path
          d="M8.47 1.318a1 1 0 0 0-.94 0l-6 3.2A1 1 0 0 0 1 5.4v.817l5.75 3.45L8 8.917l1.25.75L15 6.217V5.4a1 1 0 0 0-.53-.882zM15 7.383l-4.778 2.867L15 13.117zm-.035 6.88L8 10.082l-6.965 4.18A1 1 0 0 0 2 15h12a1 1 0 0 0 .965-.738ZM1 13.116l4.778-2.867L1 7.383v5.734ZM7.059.435a2 2 0 0 1 1.882 0l6 3.2A2 2 0 0 1 16 5.4V14a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V5.4a2 2 0 0 1 1.059-1.765z" />
      </svg>
      <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-printer "
        type="button" @click=printPage viewBox="0 0 16 16">
        <path d="M2.5 8a.5.5 0 1 0 0-1 .5.5 0 0 0 0 1" />
        <path
          d="M5 1a2 2 0 0 0-2 2v2H2a2 2 0 0 0-2 2v3a2 2 0 0 0 2 2h1v1a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2v-1h1a2 2 0 0 0 2-2V7a2 2 0 0 0-2-2h-1V3a2 2 0 0 0-2-2zM4 3a1 1 0 0 1 1-1h6a1 1 0 0 1 1 1v2H4zm1 5a2 2 0 0 0-2 2v1H2a1 1 0 0 1-1-1V7a1 1 0 0 1 1-1h12a1 1 0 0 1 1 1v3a1 1 0 0 1-1 1h-1v-1a2 2 0 0 0-2-2zm7 2v3a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1v-3a1 1 0 0 1 1-1h6a1 1 0 0 1 1 1" />
      </svg>
    </div>
  </div>
</template>
       


<script>
import Visit from '../components/Visit.vue';
import VisitList from '../components/VisitList.vue';
import CastleService from '../services/CastleService';



export default {
  components: {
    // Visit,
    VisitList,
  },
  data() {
    return {
      visit: {
        visitDate: '',
      },
    }
  },
  methods: {
    getItinerary() {
      const aDate = new Date(this.visit.visitDate);
      this.visit.visitDate = aDate.toISOString().split('T')[0];
      this.$store.dispatch('getVisitsByDate', this.visit.visitDate);
      localStorage.visitDate = this.visit.visitDate;
    },
    printPage() {
      window.print(); // This triggers the browser's print functionality
    },
    loadToday() {
      console.log('is this working?');
      let loadedDate = new Date();
      this.visit.visitDate = loadedDate.toISOString().split('T')[0];
      this.$store.dispatch('getVisitsByDate', this.visit.visitDate);
    }

  },
  async created() {
    if (this.visitId) {
      try {
        const visitResponse = CastleService.getCastleById(this.visitId);
        this.visit = visitResponse.data;
        this.$store.dispatch('getVisitsByDate', this.visit);
      } catch (error) {
        console.error(error);
      } //add better error message later

    }
    let loadedDate = new Date();
    this.visit.visitDate = loadedDate.toISOString().split('T')[0];
    this.$store.dispatch('getVisitsByDate', localStorage.visitDate);
  },


  props: ['castle']
}
</script>

<style scoped>
.main-container {
  display: flex;
  width: 100vw;
}


.list-cont {
  width: 55vw;
}

.calendar {
  display: flex;
  height: 23rem;
  padding: 20px;
  margin-bottom: 4rem;
}

.visitList {
  
  justify-content: center;
}

.bi-printer,
.bi-envelope-open,
.bi-box-arrow-up {
  display: flex;
  transform: scale(1.8);
  opacity: 75%;

}

.bi-printer:hover {
  opacity: 100%;
  transform: scale(2);
}

.bi-envelope-open:hover {
  opacity: 100%;
  transform: scale(2);
}

.bi-box-arrow-up:hover {
  opacity: 100%;
  transform: scale(2);

}

.icon-container {
  flex-direction: column;
  height: 1rem;
  margin-top: 1.5rem;
  display: flex;
  justify-content: space-between;
  height: 9rem;
}
.itinerary-name {
  /* position:relative; */
  margin-top: 1rem;
  display: flex;
  font-size: 3rem;
  justify-content: center;
  font-weight: 500;
  font-style: italic;
  text-transform: uppercase;
  text-shadow: none;
}
  
</style>
