<template>
    <div class="castleDetailPage">
        <div class="big-image" :style="{ backgroundImage: 'url(' + castle.castleBannerPhoto + ')' }">
            <div class="overlay">
                <h1 class="title">{{ castle.castleName }}</h1>
            </div>
        </div>
        <div class="information">
            <div class="description">
                <p class="body">{{ castle.longDesc }}</p>
            </div>
            <div class="google-map">
                <iframe :src="castle.mapLocation" width="600" height="450" style="border:0;" allowfullscreen=""
                    loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
            </div>
            <div id="carouselExampleIndicators" class="carousel" data-interval="false" ref="carousel">
                <div class="thumbnail">
                    <div v-for="(image, index) in images" :key="'item' + index" class="carousel-item"
                        :class="{ active: index === 0 }">
                        <img :src="image" class="d-block w-100" alt="Slide Image">
                    </div>
                </div>
                <div class="carousel-indicators">
                    <button v-for="(image, index) in images" :key="'indicator-' + index" type="button"
                        data-bs-target="#carouselExampleIndicators" :data-bs-slide-to="index"
                        :class="{ 'active': index === 0 }" aria-label="'Slide ' + (index + 1)">
                        <img :src="image" class="d-block w-100" alt="Thumbnail Image">
                    </button>
                </div>
            </div>

            <div class="icon-container">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" type="button"
                    class="bi bi-box-arrow-up" viewBox="0 0 16 16">
                    <path fill-rule="evenodd"
                        d="M3.5 6a.5.5 0 0 0-.5.5v8a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5v-8a.5.5 0 0 0-.5-.5h-2a.5.5 0 0 1 0-1h2A1.5 1.5 0 0 1 14 6.5v8a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 14.5v-8A1.5 1.5 0 0 1 3.5 5h2a.5.5 0 0 1 0 1z" />
                    <path fill-rule="evenodd"
                        d="M7.646.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1-.708.708L8.5 1.707V10.5a.5.5 0 0 1-1 0V1.707L5.354 3.854a.5.5 0 1 1-.708-.708z" />
                </svg>
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" type="button"
                    class="bi bi-envelope-open" viewBox="0 0 16 16">
                    <path
                        d="M8.47 1.318a1 1 0 0 0-.94 0l-6 3.2A1 1 0 0 0 1 5.4v.817l5.75 3.45L8 8.917l1.25.75L15 6.217V5.4a1 1 0 0 0-.53-.882zM15 7.383l-4.778 2.867L15 13.117zm-.035 6.88L8 10.082l-6.965 4.18A1 1 0 0 0 2 15h12a1 1 0 0 0 .965-.738ZM1 13.116l4.778-2.867L1 7.383v5.734ZM7.059.435a2 2 0 0 1 1.882 0l6 3.2A2 2 0 0 1 16 5.4V14a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V5.4a2 2 0 0 1 1.059-1.765z" />
                </svg>
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-printer " type="button"
                    @click=printPage viewBox="0 0 16 16">
                    <path d="M2.5 8a.5.5 0 1 0 0-1 .5.5 0 0 0 0 1" />
                    <path
                        d="M5 1a2 2 0 0 0-2 2v2H2a2 2 0 0 0-2 2v3a2 2 0 0 0 2 2h1v1a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2v-1h1a2 2 0 0 0 2-2V7a2 2 0 0 0-2-2h-1V3a2 2 0 0 0-2-2zM4 3a1 1 0 0 1 1-1h6a1 1 0 0 1 1 1v2H4zm1 5a2 2 0 0 0-2 2v1H2a1 1 0 0 1-1-1V7a1 1 0 0 1 1-1h12a1 1 0 0 1 1 1v3a1 1 0 0 1-1 1h-1v-1a2 2 0 0 0-2-2zm7 2v3a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1v-3a1 1 0 0 1 1-1h6a1 1 0 0 1 1 1" />
                </svg>
                    <h3>
                        
                    </h3>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    props: {
        castle: {
            type: Object,
            required: true
        },
        images: Array
    },
    data() {
        return {}
    },
    computed: {
        castles() {
            return this.$store.state.castle;
        }
    },
    created() {
        this.$store.dispatch('getCastleDetails');
    },
    methods: {
        printPage() {
            window.print();

        },
    },
}
</script>

<style scoped>
.overlay {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: rgba(0, 0, 0, 0.63);
    display: flex;
    justify-content: center;
    align-items: center;
    color: white;
    text-align: center;
    font-size: 2.5em;
    font-style: italic;
}


.big-image {
    height: 18vh;
    width: 100vw;
    position: relative;
    background-size: cover;
    background-position: center;
}

.carousel-item {
    transition: cubic-bezier(0.68, -0.55, 0.265, 1.55);
    height: 50vh;

    /* >img {
	vertical-align: middle;	
	position: relative;
    border: 10px solid #8bbab1; 
	top:50%;
	transform: translateY(-50%);
    } */

}

.carousel {
    height: 60vh;
    object-fit: contain;
}

.carousel-item img {
    object-fit: cover;
    height: 100%;
}

.carousel-indicators {
    bottom: 2rem;
}

.information {
    display: grid;
    grid-template-columns: 2fr 2fr;
    column-gap: 4rem;
    padding-left: 7rem;
    padding-right: 7rem;
    padding-top: 2rem;
    margin-bottom: 2rem;
}

.img-container {
    grid-area: 1 / 1;
    display: flex;
}

.google-map {
    grid-area: 1 / 2;
    width: 100%;
    margin: 0;
    height: 50vh;
}

.description {
    grid-area: 2 /1;
    width: 100%;
    height: auto;
    font-size: 1.2rem;
    align-content: start;
    font-style: italic;
}

.google-map iframe {
    width: 100%;
    height: 100%;
}

.bi-printer,
.bi-envelope-open,
.bi-box-arrow-up {
    display: flex;
    transform: scale(1.8);
    opacity: 75%;

}

.bi-printer:hover {
    opacity: 100%;
    transform: scale(2.015);
}
.bi-envelope-open:hover {
    opacity: 100%;
    transform: scale(2.015);
}

.bi-box-arrow-up:hover {
    transform: scale(2.015);
    opacity: 100%;

}

.icon-container {
    grid-area: 2 / 2;
    display: flex;
    align-items: center;
    justify-content: space-evenly;
    height: 2rem;
    width: 100%;
}</style>
