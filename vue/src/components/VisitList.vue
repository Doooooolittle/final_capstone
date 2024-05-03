<template>
        <section id="visitList">
            <Visit v-for="currentVisit in visits" 
            v-bind:key="currentVisit.visitId" 
            v-bind:visit="currentVisit" />
        </section>
</template>
<script>

import Visit from '../components/Visit.vue';
export default {
    components: {
        Visit
    },
    data() {
        return {
            visit: {
                visitDate: ''
            }
        }
    },
    computed: {
        visits() {
            return this.$store.state.visitList;
        }
    },
    
   
    props: ['visit.visitDate'],
}
</script>
<style scoped>
section#visitList {
    display: flex;
    flex-wrap: wrap;
    background-color: #FFFDF1;
    margin-top: 40px;
    justify-content: center;
    margin-bottom: 0.5rem;
}
</style>