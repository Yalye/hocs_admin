import {createRouter, createWebHistory} from 'vue-router'

const routes = [
    {
        path: '/news',
        name: 'News',
        component: () => import('../views/News.vue')
    },
    {
        path: '/websites',
        name: 'Websites',
        component: () => import('../views/Websites.vue')
    },
    {
        path: '/dashboard',
        name: 'Dashboard',
        component: () => import('../views/Dashboard.vue')
    },
    {
        path: '/about',
        name: 'About',
        component: () => import('../views/About.vue')
    }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router