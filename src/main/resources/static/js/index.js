import { setupTableListeners } from "tablesBehavior";
let selectedRows = setupTableListeners();
console.log(selectedRows);

checkJsConnectivity();
console.log("index js loaded")

const gameDiv = expandGameDiv();
moveChar();

function checkJsConnectivity() {
    const tableDiv = document.getElementById("table-div");
    const h2TableDiv = tableDiv.getElementsByTagName("h2");
    h2TableDiv[0].innerHTML = "Comments with js:"
}

function expandGameDiv() {
    const gameDiv = document.getElementById("game-div");
    const allDivs = [...document.querySelectorAll('div')];
    let heightDivSum = allDivs.filter((div) => div != gameDiv)
        .reduce((sum, div) => sum + div.offsetHeight, 0);

    let gameDivStyleProps = window.getComputedStyle(gameDiv);
    let gameDivMargins = parseFloat(gameDivStyleProps.marginTop) + parseFloat(gameDivStyleProps.marginBottom);
    console.log(heightDivSum);

    // if ()
    gameDiv.style.height = window.innerHeight - heightDivSum - 100 + gameDivMargins + 'px';
    console.log(gameDiv.style.height);

    return gameDiv;
}

function moveChar() {
    const gameP = gameDiv.querySelector("#moving-symbol");
    gameP.innerHTML = 'k';
    const pipka = "pipka-shmipka";
    var i = pipka.length - 1;

    const movingCharInterval = setInterval(() => {
        const spaceCount = gameP.innerHTML.split('&nbsp;').length - 1;

        if ((gameP.innerHTML.split('&nbsp;').length - 1) % 5 === 0 && spaceCount > 0 && i >= 0) {
            gameP.innerHTML = pipka.charAt(i) + gameP.innerHTML;
            i--;
        } else {
            i = pipka.length - 1;
            gameP.innerHTML = '&nbsp;' + gameP.innerHTML;
        }

    }, 200);
}
