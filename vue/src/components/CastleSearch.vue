<template>
    <div id="castleSearch" class="search-container">
        <input type="text" placeholder="Search by castle name" v-model.trim="search.name" @keyup="submitSearch"
            class="search-input">
    </div>
    <div class="container">
        <div id="button-container" class="d-flex" Region:>
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuClickableInside"
                    data-bs-toggle="dropdown" data-bs-auto-close="outside" aria-expanded="false">
                    Regions
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuClickableInside">
                    <img src="../assets/regions.png" />
                </ul>
            </div>

            <button type="button" class="btn btn-outline-hokkaido" v-bind="filter.region"
                @click="hokkaido">Hokkaido</button>
            <button type="button" class="btn btn-outline-tohoku" v-bind="filter.region" @click="tohoku">Tohoku</button>
            <button type="button" class="btn btn-outline-kanto" v-bind="filter.region" @click="kanto">Kanto</button>
            <button type="button" class="btn btn-outline-chubu" v-bind="filter.region" @click="chubu">Chubu</button>
            <button type="button" class="btn btn-outline-kansai" v-bind="filter.region" @click="kansai">Kansai</button>
            <button type="button" class="btn btn-outline-chugoku" v-bind="filter.region" @click="chugoku">Chugoku</button>
            <button type="button" class="btn btn-outline-shikoku" v-bind="filter.region" @click="shikoku">Shikoku</button>
            <button type="button" class="btn btn-outline-kyushu" v-bind="filter.region" @click="kyushu">Kyushu</button>
            <button type="button" class="btn btn-outline-okinawa" v-bind="filter.region" @click="okinawa">Okinawa</button>
            <button type="button" class="btn btn-outline-reset" value="Reset Filters" @click="submitSearch">Reset</button>
        </div>
    </div>
</template>


<script>
export default {


    data() {
        return {
            search: {
                name: ''
            },
            filter: {
                region: ''
            }
        }
    },
    methods: {
        submitSearch() {
            this.$store.dispatch('searchForCastle', this.search);
        },
        hokkaido() {
            this.filter.region = 'hokkaido';
            this.$store.dispatch('filterByRegion', this.filter);

        },
        tohoku() {
            this.filter.region = 'tohoku';
            this.$store.dispatch('filterByRegion', this.filter);
        },
        kanto() {
            this.filter.region = 'kanto';
            this.$store.dispatch('filterByRegion', this.filter);
        },
        chubu() {
            this.filter.region = 'chubu';
            this.$store.dispatch('filterByRegion', this.filter);
        },
        kansai() {
            this.filter.region = 'kansai';
            this.$store.dispatch('filterByRegion', this.filter);
        },
        chugoku() {
            this.filter.region = 'chugoku';
            this.$store.dispatch('filterByRegion', this.filter);
        },
        shikoku() {
            this.filter.region = 'shikoku';
            this.$store.dispatch('filterByRegion', this.filter);
        },
        kyushu() {
            this.filter.region = 'kyushu';
            this.$store.dispatch('filterByRegion', this.filter);
        },
        okinawa() {
            this.filter.region = 'okinawa';
            this.$store.dispatch('filterByRegion', this.filter);
        }
    }
}
</script>


<style scoped>
.search-container {
    display: flex;
    justify-content: center;
    align-items: center;
    padding-bottom: .7rem;
}

.container {
    display: flex;
    justify-content: center;
    align-items: center;
}

#button-container {
    display: flex;
    justify-content: space-between;
    width: 50vw;
    max-height: 3.5rem;
}

.search-input {
    width: 50vw;
    height: 4.7vh;
    box-shadow: 4px 4px 15px rgba(0, 0, 0, 0.4);
    font-size: 1em;
    padding: 8px;
    padding-left: 15px;
    border: 1.5px solid #193144;
    border-radius: 14px;
}

.ResetRegions {
    color: black
}
 #dropdownMenuClickableInside{
    color: black;
    background-color: lightgray;
    border-color: lightgray;
 }

 #dropdownMenuClickableInside:hover {
    border-color: gray;
    background-color: gray;
    color: white;
 }
.btn-outline-reset {
    color: black;
    background-color: lightgray;
    border-color: lightgray;
}

.btn-outline-reset:hover {
    border-color: gray;
    background-color: gray;
    color: white;
}

.btn-outline-hokkaido {
    color: #358057;
    border-color: #358057;
}
.btn-outline-hokkaido:hover {
    color: white;
    background-color: #358057;
    border-color: #358057;
}
.btn-outline-tohoku {
    color: #F39438;
    border-color: #F39438;
}
.btn-outline-tohoku:hover {
    background-color: #F39438;
    border-color: #F39438;
    color: white;
}

.btn-outline-kanto {
    color: #EB6363;
    border-color: #EB6363;
}

.btn-outline-kanto:hover {
    color: white;
    background-color: #EB6363;
    border-color: #EB6363;
}

.btn-outline-chubu {
    color: #3190BE;
    border-color: #3190BE;
}

.btn-outline-chubu:hover {
    color: white;
    background-color: #3190BE;
    border-color: #3190BE;
}

.btn-outline-kansai {
    color: #923063;
    border-color: #923063;
}

.btn-outline-kansai:hover {
    color: white;
    background-color: #923063;
    border-color: #923063;
}

.btn-outline-chugoku {
    color: #EB6437;
    border-color: #EB6437;
}

.btn-outline-chugoku:hover {
    color: white;
    background-color: #eb6437;
    border-color: #EB6437;
}

.btn-outline-shikoku {
    color: #80BF26;
    border-color: #80BF26;
}

.btn-outline-shikoku:hover {
    color: white;
    background-color: #80BF26;
    border-color: #80BF26;
}

.btn-outline-kyushu {
    color: #349493;
    border-color: #349493;
}

.btn-outline-kyushu:hover {
    color: white;
    background-color: #349493;
    border-color: #349493;
}

.btn-outline-okinawa {
    color: #936034;
    border-color: #936034;
}

.btn-outline-okinawa:hover {
    color: white;
    background-color: #936034;
    border-color: #936034;
}


</style>