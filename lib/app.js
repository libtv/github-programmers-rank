"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const axios_1 = require("./utils/axios");
const fs_1 = __importDefault(require("fs"));
const PROGRAMMERS_SIGN_IN = 'https://programmers.co.kr/api/v1/account/sign-in';
const PROGRAMMERS_USER_RECORD = 'https://programmers.co.kr/api/v1/users/record';
function main() {
    return __awaiter(this, void 0, void 0, function* () {
        // 환경 변수를 가져옴
        let id = process.env.GITHUB_TOKEN_ID || '';
        let pw = process.env.GITHUB_TOKEN_PW || '';
        let my_data = null;
        // 프로그래머스 로그인
        try {
            let res = yield (0, axios_1.useAxios)(PROGRAMMERS_SIGN_IN, "POST", { "user": { "email": id, "password": pw } });
            if (res.data !== null) {
                res = yield (0, axios_1.useAxios)(PROGRAMMERS_USER_RECORD, "GET", undefined, res.headers["set-cookie"]);
                my_data = res.data;
            }
        }
        catch (e) {
            console.error('axios error: ' + e);
            return;
        }
        if (my_data !== null) {
            let str = `
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
        `;
            let file_directory = __dirname.slice(0, -3) + 'dist';
            let a = fs_1.default.readFileSync(file_directory + '\\1', 'utf-8');
            let b = a + str;
            fs_1.default.writeFileSync(file_directory + '\\result.svg', b);
            console.log('success');
        }
    });
}
main();
