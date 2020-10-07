import Vue from 'vue';
import App from './App.vue';
import VueResource from "vue-resource";
import { library } from '@fortawesome/fontawesome-svg-core'
import { faUserSecret } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

library.add(faUserSecret)

Vue.component('font-awesome-icon', FontAwesomeIcon)

Vue.config.productionTip = false

export const dataBus = new Vue();

Vue.use(VueResource);

Vue.http.options.root = '/api';

new Vue({
    el: '#app',
    render: h => h(App)
});
