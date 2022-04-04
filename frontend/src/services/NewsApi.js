/**
 * Created by yalye on 6/12/21.
 */

import axiosInstance from './HttpApi'

const axios = axiosInstance

export const getNews = () => { return axios.get(`http://localhost:8000/showtime/news/`) }

export const postNews = (title, url) => { return axios.post(`http://localhost:8000/showtime/news/`, {'title': title, 'url': url}) }
