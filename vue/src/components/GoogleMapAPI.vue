<template>
    <div class="mapWhole">
        <div class="mapApi">
            <!-- <GoogleMap ref="mapRef" class="map" api-key="AIzaSyC4m-CO1YR4pNWx67QuQG6FsNqgjMIPR-s"
                style="width:90%;height:80%" :center="center" :zoom="5.5">
                <Marker :options="{ position: { lat: 35.014033, lng: 135.747825 }, visible: true, }"/>
                <Marker :options="{ position: { lat: 34.839317, lng: 134.692832 }, visible: true, }"/>
                <Marker :options="{ position: { lat: 40.607672, lng: 140.463183 }, visible: true, }"/>
                <Marker :options="{ position: { lat: 34.686975, lng: 135.525887 }, visible: true, }"/>
                <Marker :options="{ position: { lat: 36.238532, lng: 137.969576 }, visible: true, }"/>
                <Marker :options="{ position: { lat: 35.184171, lng: 136.899699 }, visible: true, }"/>
                <Marker :options="{ position: { lat: 33.845122, lng: 132.763861 }, visible: true, }"/>
                <Marker :options="{ position: { lat: 35.474845, lng: 133.049702 }, visible: true, }"/>
                <Marker :options="{ position: { lat: 35.475212, lng: 133.051891 }, visible: true, }"/>
                <Marker :options="{ position: { lat: 35.3884,   lng: 136.9392   }, visible: true, }"/>
                <Marker :options="{ position: { lat: 34.4027,   lng: 132.4591   }, visible: true, }"/>
                <Marker :options="{ position: { lat: 35.6870,   lng: 139.7556   }, visible: true, }"/>
                <Marker :options="{ position: { lat: 32.7892,   lng: 130.3673   }, visible: true, }"/>
                <Marker :options="{ position: { lat: 35.2765,   lng: 136.2518   }, visible: true, }"/>
                <Marker :options="{ position: { lat: 36.1519,   lng: 136.27046  }, visible: true, }"/>
                <Marker :options="{ position: { lat: 35.434049, lng: 136.780955 }, visible: true, }"/>
                <Marker :options="{ position: { lat: 34.286113, lng: 133.799613 }, visible: true, }"/>
                <Marker :options="{ position: { lat: 35.215084, lng: 136.842723 }, visible: true, }"/>
                <Marker :options="{ position: { lat: 36.56544,  lng: 136.657880 }, visible: true, }"/>
                <Marker :options="{ position: { lat: 35.360812, lng: 137.451786 }, visible: true, }"/>
                <Marker :options="{ position: { lat: 33.218973, lng: 132.564898 }, visible: true, }"/>
                <Marker :options="{ position: { lat: 26.405427, lng: 127.741224 }, visible: true, }"/>
            </GoogleMap> -->
        </div>
    </div>
</template>

<script>
import { ref, onMounted } from 'vue';
import { defineComponent } from 'vue';
import { GoogleMap, Marker } from "vue3-google-map";

export default defineComponent({
    components: { GoogleMap, Marker },
    setup() {
        const mapRef = ref(null);
        const center = { lat: 38.5, lng: 139.159865 }; 
        
        return {center}
    }
});

// onMounted(()=> {
//     new window.google.maps.Map(map.value, {
//         center: {lat:37.154626, lng:139.159865},
//         zoom:10
//     });
// });
// import { GoogleMap } from "vue3-google-map";
// export default {
//     components: {
//         GoogleMap,
//     },
//     data() {
//         return {
//             apiKey:"AIzaSyC4m-CO1YR4pNWx67QuQG6FsNqgjMIPR-s",
//         }
//     }
// }
</script>

<style scoped>
.mapWhole {
    display: flex;
    justify-content: center;
    height: 86vh;
    width: 100vw;
    background-position: 25%;
    background-image: url('../assets/mapBackground.jpg');
}
.mapApi {
    display: flex;
    height: 100%;
    width: 100vw;
    justify-content: center;
    align-items: center;
    display: flex;
    background: #334e49ce;
    
}
.map {
    box-shadow: 2px 0px 15px 17px rgba(0, 0, 0, 0.35);
    border: 2px solid white;
}
</style>