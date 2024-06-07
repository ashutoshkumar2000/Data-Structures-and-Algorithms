/**
 * @param {string[]} dictionary
 * @param {string} sentence
 * @return {string}
 */
var replaceWords = function(dictionary, sentence) {
    dictionary.sort();
    let arr = sentence.split(" ");
    for(let i = 0; i < arr.length; i++) {
        let ele = arr[i];
        let charArr = ele.split("");
        let builtStr = "";
        for(let char of charArr) {
            builtStr += char;
            if(dictionary.includes(builtStr)){
                arr[i] = builtStr;
                break;
            }
        }
    }
    let ans = "";
    for(let ele of arr) {
        ans += ele + " ";
    }
    return ans.trim();
};