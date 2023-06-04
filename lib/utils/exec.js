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
Object.defineProperty(exports, "__esModule", { value: true });
exports.commitFile = exports.execCmd = void 0;
const child_process_1 = require("child_process");
const execCmd = (cmd, args = []) => new Promise((resolve, reject) => {
    const app = (0, child_process_1.spawn)(cmd, args, { stdio: 'pipe' });
    let stdout = '';
    app.stdout.on('data', (data) => {
        stdout = data;
    });
    app.on('close', (code) => {
        if (code !== 0 && !stdout.includes('nothing to commit')) {
            const err = new Error(`${cmd} ${args} \n ${stdout} \n Invalid status code: ${code}`);
            return reject(err);
        }
        return resolve(code);
    });
    app.on('error', reject);
});
exports.execCmd = execCmd;
const commitFile = () => __awaiter(void 0, void 0, void 0, function* () {
    yield (0, exports.execCmd)('git', ['config', '--global', 'user.email', 'github-programmers-rank@example.com']);
    yield (0, exports.execCmd)('git', ['config', '--global', 'user.name', 'github-programmers-rank[bot]']);
    yield (0, exports.execCmd)('git', ['add', "."]);
    yield (0, exports.execCmd)('git', ['commit', '-m', '깃허브의 프로그래머스 순위를 나타내는 지표를 svg 형식으로 제공합니다.']);
    yield (0, exports.execCmd)('git', ['push']);
});
exports.commitFile = commitFile;
