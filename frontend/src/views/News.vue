<template>
  <div>
    <ag-grid-vue
        class="ag-theme-alpine"
        :columnDefs="gridOptions.columnDefs"
        :rowData="gridOptions.rowData"
        :pagination=true
        :paginationPageSize=10
    >
    </ag-grid-vue>
  </div>
</template>

<script>
import "ag-grid-community/dist/styles/ag-grid.css";
import "ag-grid-community/dist/styles/ag-theme-alpine.css";
import { AgGridVue } from "ag-grid-vue3";
import { sidebarWidth } from '../components/sidebar/state'


export default {
  name: "News",
  components: {
    AgGridVue,
  },
  setup() {
    return {
      sidebarWidth,
      gridOptions: {
        columnDefs: [
          {headerName: "Title", field: "title"},
          {headerName: "Update Time", field: "update_time"},
          {headerName: "Author", field: "author"},
          {headerName: "Website", field: "website"},
        ],
        rowData: [
          {title: "Toyota", update_time: "Celica", author: "Celica", website: "Celica"},
          {title: "Ford", update_time: "Mondeo", author: "Celica", website: "Celica"},
          {title: "Porsche", update_time: "Boxter", author: "Celica", website: "Celica"},
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
  width: 1000px;
  height: 600px;
  margin-left: 200px;
}
</style>