<template>
  <div>
    <div class="cardplus">
      <div class="card mb-3" style="width: 40vw;">
        <div class="row g-0">
          <div class="col-md-3 d-flex" >
            <router-link :to="{ name: 'castleDetail', params: { castleId: visit.castleId } }">
              <img class="visit-image" :src="visit.castleBannerPhoto" alt="bannerPhoto">
            </router-link>
          </div>
          <div class="col-md-8">
            <div class="card-body">
              <h5 class="visit-title">{{ visit.castleName }}</h5>
              <p class="visit-text">{{ visit.shortDesc }}</p>
              <p class="visit-region"><small class="text-muted" >{{ visit.region }}</small></p>
              <!-- <p class="a-thing"> more info </p> -->
              <i type="button" class="pi pi-trash" @click="deleteVisit()"></i>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
  
<!-- <div class="cardplus">
  <div class="card mb-0" style="max-width: 30vw;">
    <div class="row g-0">
      <div class="col-md-4">
        <img class="visit-image" :src="visit.castleBannerPhoto" alt="bannerPhoto">
      </div>
      <div class="col-md-8">
        <div class="card-body">
          <h5 class="visit-title">{{ visit.castleName }}</h5>
          <p class="visit-text">{{ visit.shortDesc }}</p>
          <p class="visit-region"><small class="text-muted">{{ visit.region }}</small></p>
          <i class="pi pi-trash" @click="deleteVisit()"></i> -->




<script>
import { ref } from 'vue';
import CastleService from '../services/CastleService';
import authService from "../services/AuthService";
import DashboardView from '../views/DashboardView.vue';

export default {

  props: ['visit'],

  setup() {
    const showMenu = ref(false);
    const toggleCalendar = () => {
      showMenu.value = !showMenu.value;
    }
    return { showMenu, toggleCalendar };
  },


  methods: {
    deleteVisit() {
      localStorage.visitDate = this.visit.visitDate;
      this.$store.dispatch('deleteVisitsById', this.visit.visitId);
      this.$store.dispatch('getVisitsByDate', localStorage.visitDate);
    
      window.location.reload();
    }
  }
} 
</script>

<style scoped>
.visit-image {
  width: 90%;
  height: 100%;
  aspect-ratio: 1.5/1;
  object-fit: cover;
  overflow: hidden;
  border-radius: 10px;
  border-right: solid 1.5px black;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.3);
}

.visit-title,
.visit-text,
.visit-region{
  font-style: italic;
  color: black;
  
}

.pi-trash {
  margin-top: .5rem;
  display: flex;
  width: 1rem;
  opacity: 75%;
}

.pi-trash:hover {
  opacity: 100%;
  color: rgb(184, 0, 0);
  transform: scale(1.015);
}

.cardplus {
  margin-bottom: 1.9rem;
}

.card {
  display: flex;
  border: 1.5px solid #193144;
  border-radius: 10px;
  background-color: #8BBAB1;
  box-shadow: 7px 10px 15px rgba(0, 0, 0, 0.4);
  background-image: url('https://media.istockphoto.com/id/1464221254/vector/cherry-blossoms-landscape-illustration-backgrounds-for-design-abstract-illustration-and.jpg?s=612x612&w=0&k=20&c=5H8IKnKSiVWa0OZG1GX3RJ1EylU-KocUShtYSPccjPw=');
  /* background-image: url('https://media3.giphy.com/media/Vdn2fjMv5ASxI3rZ3S/200w.gif?cid=6c09b952jy4l5n4usq9hq9hsv9rjlzsj7bb3tca0o058nvcv&ep=v1_gifs_search&rid=200w.gif&ct=g'); */
  /* background-image: url('https://static.vecteezy.com/system/resources/thumbnails/016/471/494/small_2x/sakura-branch-cherry-blossoming-flower-tree-japan-spring-flowers-background-vector.jpg'); */
  background-position: 100%;
  background-position-y: 0%;
}

.card:hover {
  transform: scale(1.015);
  
}

.img {
  opacity: 20%;
}


</style>
