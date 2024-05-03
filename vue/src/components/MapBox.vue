<template>
    <div class="mapview">
        <div class="mapColorBackground">
            <div id="mapContainer" ref="mapContainer" class="map-container"></div>
        </div>
    </div>
</template>

<script>
import mapboxgl from "mapbox-gl";

const geojsonData = {
    "features": [
        {
            "type": "Feature",
            "properties": {
                "title": "Nijo Castle",
                "description": "Japans Most Spectacular Feudal Castle",
                "marker-color": "#923063",
                "marker-symbol": "1"
            },
            "geometry": {
                "coordinates": [135.7488, 35.0142],
                "type": "Point"
            }
        },
        {
            "type": "Feature",
            "properties": {
                "title": "Himeji Castle",
                "description": "Ancient White Heron",
                "marker-color": "#923063"
            },
            "geometry": {
                "coordinates": [134.8419, 34.8394],
                "type": "Point"
            }
        },
        {
            "type": "Feature",
            "properties": {
                "title": "Hirosaki Castle",
                "description": "1 of 12 Authentic Castles in Japan",
                "marker-color": "#F39438"
            },
            "geometry": {
                "coordinates": [140.4641, 40.6090],
                "type": "Point"
            }
        },
        {
            "type": "Feature",
            "properties": {
                "title": "Osaka Castle",
                "description": "Icon of Unity",
                "marker-color": "#923063"
            },
            "geometry": {
                "coordinates": [135.5262, 34.6873],
                "type": "Point"
            }
        },
        {
            "type": "Feature",
            "properties": {
                "title": "Matsumoto-jo Castle",
                "description": "The Crow Castle",
                "marker-color": "#3190BE"
            },
            "geometry": {
                "coordinates": [137.9686, 36.2380],
                "type": "Point"
            }
        },
        {
            "type": "Feature",
            "properties": {
                "title": "Nagoya Castle",
                "description": "The Golden Shachihoko",
                "marker-color": "#3190BE"
            },
            "geometry": {
                "coordinates": [136.9042, 35.1856],
                "type": "Point"
            }
        },
        {
            "type": "Feature",
            "properties": {
                "title": "Matsuyama-jo Castle",
                "description": "Feudal Elegance",
                "marker-color": "#80BF26"
            },
            "geometry": {
                "coordinates": [132.7654, 33.8392],
                "type": "Point"
            }
        },
        {
            "type": "Feature",
            "properties": {
                "title": "Matsue-jo Castle",
                "description": "Plover Castle",
                "marker-color": "#EB6437"
            },
            "geometry": {
                "coordinates": [133.0484, 35.4723],
                "type": "Point"
            }
        },
        {
            "type": "Feature",
            "properties": {
                "title": "Matsumae Castle",
                "description": "The Lonely Castle of Hokkaido",
                "marker-color": "#358057"
            },
            "geometry": {
                "coordinates": [140.1064, 41.4292],
                "type": "Point"
            }
        },
        {
            "type": "Feature",
            "properties": {
                "title": "Inuyama Castle",
                "description": "Japans Oldest Castle Tower",
                "marker-color": "#3190BE"
            },
            "geometry": {
                "coordinates": [136.9756, 35.3801],
                "type": "Point"
            }
        },
        {
            "type": "Feature",
            "properties": {
                "title": "Hiroshima Castle",
                "description": "The Carp Castle",
                "marker-color": "#3190BE"
            },
            "geometry": {
                "coordinates": [132.4655, 34.3955],
                "type": "Point"
            }
        },
        {
            "type": "Feature",
            "properties": {
                "title": "Edo Castle Ruins",
                "description": "Heart of Historical Tokyo",
                "marker-color": "#EB6363"
            },
            "geometry": {
                "coordinates": [139.7585, 35.6848],
                "type": "Point"
            }
        },
        {
            "type": "Feature",
            "properties": {
                "title": "Shimabara Castle",
                "description": "A bastion of rebellion and faith",
                "marker-color": "#349493"
            },
            "geometry": {
                "coordinates": [130.3693, 32.7881],
                "type": "Point"
            }
        },
        {
            "type": "Feature",
            "properties": {
                "title": "Hikone Castle",
                "description": "Preserved Samurai Legacy",
                "marker-color": "#923063"
            },
            "geometry": {
                "coordinates": [136.2513, 35.2773],
                "type": "Point"
            }
        },
        {
            "type": "Feature",
            "properties": {
                "title": "Maruoka Castle",
                "description": "The Mist Castle",
                "marker-color": "#923063"
            },
            "geometry": {
                "coordinates": [136.2906, 36.1541],
                "type": "Point"
            }
        },
        {
            "type": "Feature",
            "properties": {
                "title": "Gifu Castle",
                "description": "Mountainous Stronghold",
                "marker-color": "#3190BE"
            },
            "geometry": {
                "coordinates": [136.780955, 35.434049],
                "type": "Point"
            }
        },
        {
            "type": "Feature",
            "properties": {
                "title": "Marugame Castle",
                "description": "The Fan-shaped Fortress",
                "marker-color": "#80BF26"
            },
            "geometry": {
                "coordinates": [133.799613, 34.286113],
                "type": "Point"
            }
        },
        {
            "type": "Feature",
            "properties": {
                "title": "Kiyosu Castle",
                "description": "The Unifiers Assembly Hall",
                "marker-color": "#3190BE"
            },
            "geometry": {
                "coordinates": [136.842723, 35.215084],
                "type": "Point"
            }
        },
        {
            "type": "Feature",
            "properties": {
                "title": "Kanazawa Castle",
                "description": "Historic Maeda Clan Fortress",
                "marker-color": "#3190BE"
            },
            "geometry": {
                "coordinates": [136.657880, 36.56544],
                "type": "Point"
            }
        },
        {
            "type": "Feature",
            "properties": {
                "title": "Iwamura Castle",
                "description": "Ancient Mountain Fortress",
                "marker-color": "#3190BE"
            },
            "geometry": {
                "coordinates": [137.451786, 35.360812],
                "type": "Point"
            }
        },
        {
            "type": "Feature",
            "properties": {
                "title": "Uwajima Castle",
                "description": "Original Hilltop Castle",
                "marker-color": "#80BF26"
            },
            "geometry": {
                "coordinates": [132.564898, 33.218973],
                "type": "Point"
            }
        },
        {
            "type": "Feature",
            "properties": {
                "title": "Zakimi Castle Ruins",
                "description": "Historic Fortress Ruins in Okinawa",
                "marker-color": "#936034"
            },
            "geometry": {
                "coordinates": [127.741224, 26.405427],
                "type": "Point"
            }
        },
    ],
    "type": "FeatureCollection"
};

mapboxgl.accessToken = "pk.eyJ1IjoiamtuYWhheSIsImEiOiJjbHY0OWNucXcwNmZiMndtc29ld2FwcDV2In0.bJ_p63ehT0V3LBk7v3Fc1Q"
export default {
    components: {

    },
    mounted() {
        const mapDoc = document.getElementById("mapContainer")
        const map = new mapboxgl.Map({
            container: mapDoc,
            style: "mapbox://styles/mapbox/streets-v12",
            center: [137.391614, 35.031578],
            zoom: 4.3,
        });
        map.on('load', () => {
            map.resize();
            //load json on map
            geojsonData.features.forEach((feature) => {
                const symbol = feature.properties['marker-symbol'] || 'religious-shinto.svg'; //defaults generic marker
                const color = feature.properties['marker-color'] || '#FF0000'; //defaults red
                const marker = new mapboxgl.Marker({ color: color })
                    .setLngLat(feature.geometry.coordinates)
                    .setPopup(new mapboxgl.Popup({ offset: 25 })
                        .setHTML(`<h3>${feature.properties.title}</h3>
                          <p>${feature.properties.description}</p>`))
                    .addTo(map);
            });
        });
        this.map = map;
    },
    unmounted() { //best practice safety method
        if (this.map) {
            this.map.remove();
        }
    }
}
</script>

<style>
.map-container {
    width: 90vw;
    height: 70vh;
    box-shadow: 2px 0px 15px 17px rgba(0, 0, 0, 0.35);
    border: 2px solid white;
}

.mapview {
    height: 86vh;
    display: flex;
    justify-content: center;
    align-items: center;
    background-position: 25%;
    background-image: url('../assets/mapBackground.jpg');
}

.mapboxgl-ctrl-bottom-right,
.mapboxgl-ctrl-bottom-left {
    opacity: 0;
}

.mapColorBackground {
    display: flex;
    height: 100%;
    width: 100vw;
    justify-content: center;
    align-items: center;
    display: flex;
    background: #334e49ce;
}

</style>