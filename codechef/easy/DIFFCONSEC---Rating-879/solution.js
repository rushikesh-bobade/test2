function Wordle(tests) {
    let t = parseInt(tests[0]);
    let index = 1;
    let ans = [];

    for (let i = 0; i < t; i++) {
        let n = parseInt(tests[index++]);
        let s = tests[index++].trim();

        let count = 0;

        for (let j = 1; j < n; j++) {
            if (s[j] === s[j - 1]) {
                count++;
            }
        }

        ans.push(count);
    }

    console.log(ans.join('\n'));
}

// Input related code. Please do not change.
process.stdin.setEncoding('utf8');
let input = '';

process.stdin.on('data', function(chunk) {
    input += chunk;
});

process.stdin.on('end', function() {
    const tests = input.trim().split('\n');
    Wordle(tests);
});