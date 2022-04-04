<template>
  <div>
    <ag-grid-vue
        style="width: 500px; height: 200px"
        class="ag-theme-alpine"
        :columnDefs="gridOptions.columnDefs"
        :rowData="gridOptions.rowData"
    >
    </ag-grid-vue>
  </div>
</template>

<script>
import "ag-grid-community/dist/styles/ag-grid.css";
import "ag-grid-community/dist/styles/ag-theme-alpine.css";
import { AgGridVue } from "ag-grid-vue3";

export default {
  name: "News",
  components: {
    AgGridVue,
  },
  setup() {
    return {
      gridOptions: {
        columnDefs: [
          {headerName: "Make", field: "make"},
          {headerName: "Model", field: "model"},
          {headerName: "Price", field: "price"},
        ],
        rowData: [
          {make: "Toyota", model: "Celica", price: 35000},
          {make: "Ford", model: "Mondeo", price: 32000},
          {make: "Porsche", model: "Boxter", price: 72000},
        ]
      }
    };
  },
};
</script>

<style scoped>
@import "~ag-grid-community/dist/styles/ag-grid.css";
@import "~ag-grid-community/dist/styles/ag-theme-alpine.css";
.ag-theme-alpine {
  @include ag-theme-alpine((
  odd-row-background-color: #ACE
  ));
}
</style>