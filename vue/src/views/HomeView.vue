<template>
  <!-- <div class="home">

    <div class="overlay">
      <h1>Unlock the Majesty of Japan's Castles </h1>
      <router-link v-bind:to="{ name: 'castles' }">
        <button type="button" class="btn btn-primary">Explore!</button>
      </router-link>
      </div>
  </div> -->
  

  <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-indicators">
      <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
      <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
      <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>

  <div class="carousel-inner">
    
    <div class="carousel-item active">
      <div class="image-container">
        <img src="https://www.wendywutours.co.nz/resource/upload/900/banner-osaka-castle.jpg" class="d-block w-100" alt="...">
        <div class="carousel-caption d-none d-md-block overlay">
          <div class="overlay">
            <h1>Unlock the Majesty of Japan's Castles</h1>
            <!-- <h1>Japan's Castles</h1> -->
            <router-link v-bind:to="{ name: 'castles' }">
              <button type="button" class="btn btn-primary">Explore!</button>
            </router-link>
          </div>
        </div>
      </div>
    </div>

    <div class="carousel-item">
      <img src="https://cdn.vox-cdn.com/thumbor/3n0sYZ7eyLb02o64_23RygDsbYU=/0x756:5040x3276/fit-in/1200x600/cdn.vox-cdn.com/uploads/chorus_asset/file/25237910/riccardo_bergamini_O2yNzXdqOu0_unsplash.jpg" class="d-block w-100" alt="...">
      <div class="image-container">
        <div class="carousel-caption d-none d-md-block overlay">
          <div class="overlay">
            <h1>Food? </h1>
            <router-link v-bind:to="{ name: 'castles' }">
              <button type="button" class="btn btn-primary">Explore!</button>
            </router-link>
          </div>
        </div>
      </div>
    </div>
 

    <div class="carousel-item">
      <img src="https://www.japantimes.co.jp/uploads/imported_images/uploads/2022/10/np_file_187800.jpeg" class="d-block w-100" alt="...">
      <div class="image-container">
        <div class="carousel-caption d-none d-md-block overlay">
          <div class="overlay">
            <h1>Theme Parks</h1>
            <router-link v-bind:to="{ name: 'castles' }">
              <button type="button" class="btn btn-primary">Explore!</button>
            </router-link>
          </div>
        </div>
      </div>
    </div>
  

    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Previous</span>
    </button>

    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Next</span>
    </button>

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
.carousel { 
  height: 85vh;
  width: 100vw; 
  object-fit: cover;
  display: flex;
}

.carousel-caption {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100%; /* Ensure full height */
  margin-top: 10px;
}



.carousel-caption h1 {
  white-space: nowrap;
  margin-bottom: 10px; /* Adjust as needed */
}

h1 {
  font-size: 4em;
  font-style: italic;
  color: white;
  text-shadow: 2px 2px 4px black;
  display: inline; 
}

.carousel-item {
  height: 400px; /* Adjust the height as needed */
  position: relative; /* Ensure positioning context for absolute positioning */
}

.carousel-caption button {
  margin-top: 10px; /* Adjust as needed */
}

 .home {
  /* height: 100vh;
  width: 100vw;
  position: relative;
  background-size: cover;
  background-position: 50%; */
  /* background-image: url('https://www.wendywutours.co.nz/resource/upload/900/banner-osaka-castle.jpg'); */
  /* background-image: url('https://media3.giphy.com/media/Vdn2fjMv5ASxI3rZ3S/200w.gif?cid=6c09b952jy4l5n4usq9hq9hsv9rjlzsj7bb3tca0o058nvcv&ep=v1_gifs_search&rid=200w.gif&ct=g');
  box-shadow: 0 0 300px rgb(0, 0, 0) inset; */
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


.overlay {
  position: absolute;
  top: 70%;
  left: 50%;
  transform: translate(-50%, -50%);
}
  
.carousel-control-prev-icon,
.carousel-control-next-icon {
  background-color: #ddd;
  border: none;
  color: black;
  padding: 32px;
  text-align: center;
  font-size: 50px;
  margin: 4px 2px;
  transition: 0.3s;
  border-radius: 25px;
}

.carousel-control-prev-icon:hover,
.carousel-control-next-icon:hover {
  background-color: #3e8e41;
  color: #193144;
}




</style>