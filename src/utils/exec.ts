import {spawn} from 'child_process';

export const execCmd = (cmd: string, args: string[] = []) =>
    new Promise((resolve, reject) => {
        const app = spawn(cmd, args, {stdio: 'pipe'});
        let stdout = '';
        app.stdout.on('data', (data: any) => {
            stdout = data;
        });
        app.on('close', (code: any) => {
            if (code !== 0 && !stdout.includes('nothing to commit')) {
                const err = new Error(`${cmd} ${args} \n ${stdout} \n Invalid status code: ${code}`);
                return reject(err);
            }
            return resolve(code);
        });
        app.on('error', reject);
    });

export const commitFile = async (files: any) => {
    await execCmd('git', ['config', '--global', 'user.email', 'github-programmers-rank@example.com']);
    await execCmd('git', ['config', '--global', 'user.name', 'github-programmers-rank[bot]']);
    await execCmd('git', ['add', files]);
    await execCmd('git', ['commit', '-m', '깃허브의 프로그래머스 순위를 나타내는 지표를 svg 형식으로 제공합니다.']);
    await execCmd('git', ['push']);
}