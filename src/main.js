import { series } from "./data.js";
function insert(series) {
    const tableBody = document.getElementById("series-body");
    if (!tableBody)
        return;
    series.forEach((serie) => {
        const trElement = document.createElement("tr");
        trElement.innerHTML = `
      <td class="fw-bold">${serie.id}</td>
      <td><a href="${serie.website}" target="_blank">${serie.name}</a></td>
      <td>${serie.channel}</td>
      <td>${serie.seasons}</td>
    `;
        tableBody.appendChild(trElement);
    });
    const totalTemporadas = series.reduce((total, serie) => total + serie.seasons, 0);
    const promedio = totalTemporadas / series.length;
    const summaryRow = document.createElement("tr");
    summaryRow.innerHTML = `<td colspan="4" class="text-start fw-bold">Promedio de temporadas: ${promedio.toFixed(2)}</td>`;
    tableBody.appendChild(summaryRow);
}
document.addEventListener("DOMContentLoaded", () => {
    console.log(series);
    insert(series);
});
