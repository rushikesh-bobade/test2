function Wordle(tests) {
    let t = parseInt(tests[0]);
    let result = [];

    for (let i = 1; i < tests.length; i += 2) {
        const s = tests[i];
        const guess = tests[i + 1];

        let ans = "";

        for (let j = 0; j < 5; j++) {
            if (s[j] === guess[j]) {
                ans += "G";
            } else {
                ans += "B";
            }
        }

        result.push(ans);
    }

    console.log(result.join("\n"));
}

// Input related code. Please do not change. 
process.stdin.setEncoding('utf8');
process.stdin.on('data', function(input) {
    const tests = input.trim().split('\n');
    Wordle(tests);
});