<template>
  <div class="home">

    <div class="overlay">
      <h1>Unlock the Majesty of Japan's Castles </h1>
      <router-link v-bind:to="{ name: 'castles' }">
        <button type="button" class="btn btn-primary">Explore!</button>
      </router-link>
      </div>
  </div>
  <Premium/>
</template>

<script>
import Premium from '../components/Premium.vue';
export default {
  components: {
    Premium
  }
};
</script>

<style scoped>
h1 {
  font-size: 4em;
  font-style: italic;
  color: white;
  margin-bottom: 22rem;
  text-shadow: 2px 2px 4px black;
}

.home {
  height: 100vh;
  width: 100vw;
  position: relative;
  background-size: cover;
  background-position: 50%;
  background-image: url('https://www.wendywutours.co.nz/resource/upload/900/banner-osaka-castle.jpg');
  /* background-image: url('https://media3.giphy.com/media/Vdn2fjMv5ASxI3rZ3S/200w.gif?cid=6c09b952jy4l5n4usq9hq9hsv9rjlzsj7bb3tca0o058nvcv&ep=v1_gifs_search&rid=200w.gif&ct=g'); */
  box-shadow: 0 0 300px rgb(0, 0, 0) inset;
}

.btn-primary {
  font-size: 1.6em;
  background-color: #fdb6b7;
  border-radius: 10px;
  width: 10vw;
  height: 3vw;
  color: #193144;
  border:none;
  font-style: italic;
  margin-bottom: 6rem;
  box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.4);
}

.btn-primary:hover {
  font-weight: 500;
  font-style: italic;
  color: #000;
  background-color: #fdb6b7;
  transform: scale(1.05);
  box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.4);
}

.text {
  display: flex;
  justify-content: center;
  margin: 10px;
  
}

.overlay {
  position: absolute;
  height: 100vh;
  width: 100vw;
  background: rgba(0, 0, 0, 0.37);
  color: rgb(0, 0, 0);
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  
}
</style>