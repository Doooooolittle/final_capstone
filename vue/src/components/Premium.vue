<template>
    <div class="premium">
    <h2 class = "join"> Join the Clan Today! </h2>
    <router-link v-bind:to="{ name: 'register' }" class="nav-link"><img src="../assets/Foxtrots- Screenshots/Dashboard.png" alt="logo" width="125" height="125" class="premium-dash" /> </router-link>
    <h6 class="sign-up-text"> Sign up to be able  to add castles to a personalized dashboard!</h6>
    </div>  
  </template>






<style>
.premium {
    display: flex;
    flex-direction: column;
    justify-content:space-around;
    align-items: center;
    color: white;
    background-color: #193144;
    height: 100vh;
    border-top: solid 2px #8BBAB1;
    
}
.join{
    font-size: 5rem;
    font-style: italic;
    text-shadow: 2px 2px 4px black;
}
.sign-up-text{
  font-size: 1.3rem;
  font-style: italic;
  text-shadow: 2px 2px 4px black;
}
.premium-dash {
    display: flex;
    justify-self: center;
    margin-top: 2rem;
    border-radius: 5px;
    transform: scale(4);
    border: solid .75px #8BBAB1;
    width: 17rem;
    
   
}
</style>