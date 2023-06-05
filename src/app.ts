import { useAxios } from "./utils/axios"
import fs from 'fs'

const PROGRAMMERS_SIGN_IN = 'https://programmers.co.kr/api/v1/account/sign-in'
const PROGRAMMERS_USER_RECORD = 'https://programmers.co.kr/api/v1/users/record'

async function main() {
    // 환경 변수를 가져옴
    let id = process.env.GITHUB_TOKEN_ID || ''
    let pw = process.env.GITHUB_TOKEN_PW || ''
    let my_data = null;
    
    console.log(id);

    // 프로그래머스 로그인
    try {
        let res = await useAxios(PROGRAMMERS_SIGN_IN, "POST", {"user":{"email": id,"password": pw}})
        if (res.data !== null) {
            res = await useAxios(PROGRAMMERS_USER_RECORD, "GET", undefined, res.headers["set-cookie"]);
            my_data = res.data
        }
    } catch (e) {
        console.error('axios error: ' + e)
        return;
    }
    
    if (my_data !== null) {
        let str = 
        `
            <text text-anchor="middle" x="80" y="45" class="title" style="fill:#0078ff;" stroke="#none" stroke-width="1" >정복 중인 레벨</text>
            <text text-anchor="middle" x="40" y="85" class="desc" stroke="#none" stroke-width="1" >${my_data.skillCheck.level}</text>
            <text text-anchor="middle" x="70" y="85" class="desc-2" stroke="#none" stroke-width="1" >레벨</text>
            
            <text text-anchor="middle" x="340" y="45" class="title" style="fill:#0078ff;" stroke="#none" stroke-width="1" >현재 점수</text>
            <text text-anchor="middle" x="360" y="85" class="desc" stroke="#none" stroke-width="1" >${my_data.ranking.score.toLocaleString('ko-KR')}</text>
            
            <text text-anchor="middle" x="100" y="150" class="title" style="fill:#0078ff;" stroke="#none" stroke-width="1" >해결한 코딩 테스트</text>
            <text text-anchor="middle" x="65" y="190" class="desc" stroke="#none" stroke-width="1" >${my_data.codingTest.solved}</text>
            <text text-anchor="middle" x="120" y="190" class="desc-2" stroke="#none" stroke-width="1" >문제</text>
            
            <text text-anchor="middle" x="340" y="150" class="title" style="fill:#0078ff;" stroke="#none" stroke-width="1" >나의 랭킹</text>
            <text text-anchor="middle" x="370" y="190" class="desc" stroke="#none" stroke-width="1" >${my_data.ranking.rank.toLocaleString('ko-KR')}</text>
            <text text-anchor="middle" x="450" y="190" class="desc-2" stroke="#none" stroke-width="1" >위</text>
        </svg>
        `

        let file_directory = __dirname.slice(0, -3) + 'dist'
        let a = fs.readFileSync(file_directory + '\\1', 'utf-8')
        let b = a + str

        fs.writeFileSync(file_directory + '\\result.svg', b)
        console.log('success')
    }
}

main();