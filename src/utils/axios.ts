import axios, {AxiosRequestConfig} from 'axios'

type AXIOS_METHOD = 'POST' | 'GET';

export async function useAxios(url:string, method: AXIOS_METHOD, data?: any, query?: string[]) {
    if (data !== undefined) return axios({ url: url, method: method, data: data })

    return axios({ url: url, method: method, headers: {Cookie: query?.concat('; ')} })
}