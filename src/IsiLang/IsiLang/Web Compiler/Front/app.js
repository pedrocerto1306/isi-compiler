var code = document.getElementById("code-editor");

function createScript() {
    if (code.children.length >= 1) {
        if (confirm("If you create another script, the current one will be lost forever!\nWant do continue?")) {
            code.removeChild(code.firstElementChild); //script
            code.removeChild(code.firstElementChild); //console
        } else {
            return;
        }
    }

    let scriptArea = document.createElement("div");
    scriptArea.setAttribute("contenteditable", "true")
    scriptArea.setAttribute("class", "col-8 isi-block");
    scriptArea.setAttribute("id", "isi-script");
    scriptArea.setAttribute("style", "text-align: left; justify-content: left; height: 750px; font-weight:400;")
    // scriptArea.innerHTML = "<span style='color:#0066ff'>programa</span><br><br><div class='main-code'></div><br><br><span style='color:#0066ff'>fimprog.</span>";
    // scriptArea.addEventListener("change", () => {
    //     var splittedCode = scriptArea.textContent.split(" ");
    //     console.log(splittedCode[0]);
    // });

    scriptArea.addEventListener('keydown', (e) => {
        if (e.key === 'Tab') {
            e.preventDefault();
            document.querySelector(".isi-script").textContent += "\t";
        }
        // e.target.innerHTML = e.target.innerHTML.replace(/programa|declare|leia|escreva|se|entao|senao|fimprog./g, (match) => {
        //     if (match == 'programa' || match == 'fimprog.') {
        //         return `<span style='color: #0066ff'>${match}</span>`;
        //     } else if (match == 'se' || match == 'senao' || match == 'entao') {
        //         return `<span style='color: #d48a00'>${match}</span>`;
        //     } else if (match == 'declare' || match == 'leia' || match == 'escreva') {
        //         return `<span style='color: #d42000'>${match}</span>`;
        //     } else if (match == '(' || match == ')') {
        //         return `<span style='color: blue'>${match}</span>`;
        //     } else if (match == '{' || match == '}') {
        //         return `<span style='color: orange'>${match}</span>`;
        //     } else {
        //         return `<span style='color: darkgray'>${match}</span>`;
        //     }
        // });
    });

    //Pseudo lexer para highlight
    scriptArea.addEventListener("blur", (e) => {
        e.target.innerHTML = e.target.innerHTML.replace(/programa|declare|leia|escreva|senao|se|entao|real|text|enquanto|faça|fimprog./gi, (match) => {
            if (match == 'programa' || match == 'fimprog.') {
                return `<span style='color: #0066ff; font-weight:550;'>${match}</span>`
            } else if (match == 'se' || match == 'senao' || match == 'entao') {
                return `<span style='color: #d48a00; font-weight:550;'>${match}</span>`
            } else if (match == 'declare' || match == 'leia' || match == 'escreva') {
                return `<span style='color: #d42000; font-weight:550;'>${match}</span>`
            } else if (match == '(' || match == ')') {
                return `<span style='color: blue; font-weight:550;'>${match}</span>`
            } else if (match == '{' || match == '}') {
                return `<span style='color: orange; font-weight:550;'>${match}</span>`
            } else {
                return `<span style='color: darkgray; font-weight:550;'>${match}</span>`
            }
        })
    });

    let isiConsole = document.createElement("div");
    isiConsole.className = "col-4";
    let consoleTitle = document.createElement("h6");
    consoleTitle.innerHTML = `console <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-terminal" viewBox="0 0 16 16">
                            <path d="M6 9a.5.5 0 0 1 .5-.5h3a.5.5 0 0 1 0 1h-3A.5.5 0 0 1 6 9zM3.854 4.146a.5.5 0 1 0-.708.708L4.793 6.5 3.146 8.146a.5.5 0 1 0 .708.708l2-2a.5.5 0 0 0 0-.708l-2-2z"/>
                            <path d="M2 1a2 2 0 0 0-2 2v10a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V3a2 2 0 0 0-2-2H2zm12 1a1 1 0 0 1 1 1v10a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V3a1 1 0 0 1 1-1h12z"/>
                            </svg>`;
    let consoleContent = document.createElement("span");
    consoleContent.setAttribute("id", "console-content");

    isiConsole.appendChild(consoleTitle);
    isiConsole.appendChild(document.createElement("hr"));
    isiConsole.appendChild(consoleContent);

    code.appendChild(scriptArea);
    code.appendChild(isiConsole);
}

function saveScript() {
    var consoleContent = document.getElementById("console-content");

    var script = document.createElement("a");
    script.href = window.URL.createObjectURL(new Blob(
        [document.querySelector("#isi-script").innerText],
        { type: "text/plain" }));
    script.download = "isiscript.isi";
    script.click();

    consoleContent.innerHTML += "isilang >> File Saved!<br>"
}

function changeTheme() {
    if (document.body.style.backgroundColor == "rgb(48, 52, 61)") {
        document.body.style.backgroundColor = "#F6F6F6";
        document.body.style.color = "rgb(48, 52, 61)";
    } else {
        document.body.style.backgroundColor = "rgb(48, 52, 61)";
        document.body.style.color = "#FFFFFF";
    }
}