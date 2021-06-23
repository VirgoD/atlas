import Auth from "@okta/okta-vue";
import Vue from 'vue';
import Router from 'vue-router';
import Home from './components/Home.vue';
import Login from './components/Login.vue';
import Register from './components/Register.vue';

Vue.use(Auth, {
  issuer: 'https://localhots:8080/oauth2/default',
  client_id: 'dev-29924156.okta.com',
  redirect_uri: window.location.origin + '/implicit/callback',
  scope: 'openid profile email'
});

Vue.use(Router);

export const router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/home',
      component: Home
    },
    {
      path: '/login',
      component: Login
    },
    {
      path: '/register',
      component: Register
    },
    {
      path: '/profile',
      name: 'profile',
      // lazy-loaded
      component: () => import('./components/Profile.vue')
    },
    {
      path: '/default',
      name: 'default',
      // lazy-loaded
      component: () => import('./components/BoardDefault.vue')
    },
    {
      path: '/azienda',
      name: 'azienda',
      component: () => import('./components/Azienda.vue')
    },
    {
      path: '/addAzienda',
      name: 'addAzienda',
      component: () => import('./components/AddAzienda.vue')
    },
    {
      path: '/addGara',
      name: 'addGara',
      component: () => import('./components/AddGara.vue')
    },
    {
      path: '/addBanditore',
      name: 'addBanditore',
      component: () => import('./components/AddBanditore.vue')
    },
    {
      path: '/banditore',
      name: 'banditore',
      component: () => import('./components/Banditore.vue')
    },
    {
      path: '/gara',
      name: 'gara',
      component: () => import('./components/Gara.vue')
    },
    {
      path: '/deleteAzienda',
      name: 'deleteAzienda',
      component: () => import('./components/DeleteAzienda.vue')
    },
    {
      path: '/modificaAzienda',
      name: 'modificaAzienda',
      component: () => import('./components/modificaAzienda.vue')
    },
    {
      path: '/modifyBanditore',
      name: 'modifyBanditore',
      component: () => import('./components/modifyBanditore.vue')
    },
    {
      path: '/modifyGara',
      name: 'modifyGara',
      component: () => import('./components/ModifyGara.vue')
    },
    {
      path: '/rimuoviAzienda',
      name: 'rimuoviAzienda',
      component: () => import('./components/RimuoviAzienda.vue')
    },
    {
      path: '/implicit/callback',
      component: Auth.handleCallback(),
    },
  ]
});

router.beforeEach((to, from, next) => {
  const publicPages = ['/login', '/register', '/home', '/azienda', '/banditore','/gara'];
  const authRequired = !publicPages.includes(to.path);
  const loggedIn = localStorage.getItem('user');
  Vue.prototype.$auth.authRedirectGuard();
  // trying to access a restricted page + not logged in
  // redirect to login page
  if (authRequired && !loggedIn) {
    next('/login');
  } else {
    next();
  }
});