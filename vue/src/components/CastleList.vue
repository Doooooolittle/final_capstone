<template>
    <body id="body">
        <section id="castleList">
            <Castle v-for="currentCastle in castles" 
            v-bind:key="currentCastle.castleId" 
            v-bind:castle="currentCastle" />
        </section>
    </body>
</template>
<script>
import Castle from './Castle.vue';
export default {
    components: {
        Castle
    },
    data() {
        return {
            nameFilter : ''
        }
    },
    computed: {
        castles() {
            return this.$store.state.castleList;
        }
    },
    created() {
        this.$store.dispatch('getAllCastles');
    }
}
</script>
<style scoped>
section#castleList {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-evenly;
    background-color: #FFFDF1;
    padding-top: 4px;
}
</style>