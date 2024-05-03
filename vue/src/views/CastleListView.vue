<template>
    <div class="search">
        <CastleSearch />
    </div>
    <div class="list">
        <CastleList />
    </div>
</template>

<script>
import CastleList from '../components/CastleList.vue';
import CastleSearch from '../components/CastleSearch.vue';
export default {
    components: {
        CastleList,
        CastleSearch
    }
}
</script>

<style scoped>
.search {
    position: fixed;
    width: 100%; /* width: 99% allows scrollbar to be shown but search is offset */
    top: 7.95rem;
    z-index: 10;
    background-color: #FFFDF1;
    height: 7.5rem;
    align-content: center;
    border-bottom: 2px solid #8BBAB1;
}
h1 {
    display: flex;
    justify-content: center;
}
.list {
    margin-top: 8.7rem;
}
</style>
