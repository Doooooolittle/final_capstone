<template>
  <div id="capstone-app">
    <TheHeader />
    <div class="content">
      <router-view />
      <TheFooter />
    </div>
  </div>
</template>

<script>
import TheHeader from './components/TheHeader.vue';
import TheFooter from './components/TheFooter.vue';

export default {
  components: {
    TheHeader,
    TheFooter
  }
};
</script> 

<style>
#capstone-app {
  /* Makes the whole app take up 100vh */
  background-color: #FFFDF1;
  display: flex;
  flex-direction: column;
  height: 100vh;
}

Header {
  /* This is to lock the header in place when scroll is available */
  width: 100%;
  position: fixed;
  top: 0;
  z-index: 1000;
}

.content {
  /* This is to get the content to scroll */
  flex: 1;
  margin-top: 0px;
  overflow-y: auto;
  overflow-x: hidden !important;
}

body {
  margin: 0 !important;
  overflow-x: hidden !important;
  font-family: "Comic Sans MS", "Comic Sans", cursive;
}
</style>