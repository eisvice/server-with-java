export function setupTableListeners() {
    const table = document.getElementById("comment-table");
    let selectedRows = [];

    if (table) {
        table.addEventListener('click', (event) => {
            const row = event.target.closest("tr");
            if (row && !row.classList.contains("table-header")) {
                if (!row.classList.contains("selected")) {
                    console.log("wohoo row was clicked!");
                    row.classList.add("selected");
                    selectedRows.push(row.dataset.elId);
                    console.log(selectedRows);
                } else {
                    row.classList.remove("selected");
                    selectedRows = removeRow(selectedRows, row);
                    console.log(selectedRows);
                }
            }
        });

    } else {
        console.warn("no table :(");
    }

    return selectedRows;
}

function removeRow(selectedRows, row) {
    selectedRows.forEach((item, index) => {
        if (item === row.dataset.elId) {
            selectedRows.splice(index, 1);
        }
    });
    return selectedRows;
}