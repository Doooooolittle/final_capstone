<template>
    <div id="header">
        <router-link to="/"><img src="../assets/logo.png" alt="logo" width="125" height="125" class="pic"></router-link>
        <h1>Castles of Japan | 日本の城 </h1>

        <nav id="nav" class="d-flex">
            <router-link v-bind:to="{ name: 'home' }" class="nav-link" v-if="!isHomePage"><i class="pi pi-home"></i> Home</router-link>
            <span class="bars" v-if="!isHomePage"> &nbsp;|&nbsp;</span>
            <router-link v-bind:to="{ name: 'castles' }" class="nav-link" v-if="!isExplorePage"> <i class="pi pi-search"></i> Explore Castles</router-link>
            <span class="bars" v-if="!isExplorePage"> &nbsp;|&nbsp;</span>
            <router-link v-bind:to="{ name: 'dashboard' }" class="nav-link" v-if="!isDashboardPage && isAuthenticated"><i class="pi pi-desktop"></i>  My Dashboard</router-link>
            <span class="bars" v-if="!isDashboardPage && isAuthenticated"> &nbsp;|&nbsp;</span>
            <router-link v-bind:to="{ name: 'map' }" class="nav-link" v-if="!isMapPage"> <i class="pi pi-map"></i> Map</router-link>
            <span class="bars" v-if="!isMapPage && !isLoginPage"> &nbsp;|&nbsp;</span>
            <router-link v-bind:to="{ name: 'login' }" class="nav-link" v-if="!isLoginPage && !isAuthenticated">Sign In &nbsp; </router-link>
            <!--" v-if="$store.state.token = ''"-->
            <router-link v-bind:to="{ name: 'logout' }" class="nav-link" v-if="isAuthenticated">Sign Out &nbsp; </router-link>
            <!--" v-if="$store.state.token != ''"-->
        </nav>
    </div>
</template>



<script>


export default {
    computed: {
        isAuthenticated() {
            return !!this.$store.state.token ;
        },
        isLoginPage() {
            return this.$route.name === 'login';
        },
            isHomePage() {
            return this.$route.name === 'home';
        },
            isDashboardPage() {
            return this.$route.name === 'dashboard';
        },
            isExplorePage() {
            return this.$route.name === 'castles';
        },
            isMapPage() {
            return this.$route.name === 'map';
        }

    }
}


</script>



<style scoped>
#pic {
    overflow: hidden;
}

.pic:hover {
    transform: scale(1.01);
    border-bottom: 1px solid #8BBAB1;
}

#header {
    width: 100vw;
    display: flex;
    align-items: center;
    color: #193144;
    border-bottom: 2px solid #8BBAB1;
}

#nav {
    margin-left: auto;
}

.nav-link {
    text-decoration: none;
    color: inherit;
    margin: .8vw;
    font-size: 1.4em;
    /* text-shadow: 2px 2px 4px black;  */
}

.nav-link:hover {
    font-size: 1.5em;
    font-weight: 300;
    /* color: #8BBAB1; */
    font-style: italic;
}

.bars {
    display: flex;
    align-items: center;
    font-size: 1.5em;
    color: inherit;
}
/* h1 {
    text-shadow: 2px 2px 4px black; 
    }  */

</style>