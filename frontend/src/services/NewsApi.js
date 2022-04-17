/**
 * Created by yalye on 6/12/21.
 */

import axiosInstance from './HttpApi'

const axios = axiosInstance

export const getNews = () => { return axios.get(`http://localhost:8080/news/list?page=1&size=20`) }

export const postNews = (title, url) => { return axios.post(`http://localhost:8000/showtime/news/`, {'title': title, 'url': url}) }
