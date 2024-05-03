<template>
    <MapBox />
</template>

<script>
import MapBox from '../components/MapBox.vue';
export default {
    components: {
        MapBox
    },
    data: () => ({
    location: {
      lng: -71.224518,
      lat: 42.213995,
      bearing: 0,
      pitch: 0,
      zoom: 9,
    },
  }),
}
</script>
