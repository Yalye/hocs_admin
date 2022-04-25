<template>
  <div>
    <ag-grid-vue
        class="ag-theme-alpine"
        :columnDefs="gridOptions.columnDefs"
        @grid-ready="onGridReady"
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
import { sidebarWidth } from '@/components/sidebar/state'
import {getNews} from "@/services/NewsApi";

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
          {headerName: "Title", field: "title",width:500,
            cellRenderer: function (params) {
              let title = params.data.title;
              let url = params.data.url;
              let newLink = `<a href= ${url} target="_blank">${title}</a>`;
              console.log(newLink)
              return newLink;
            },
            resizable: true
          },
          {headerName: "Update Time", field: "updateTime",width:150,},
          {headerName: "Author", field: "author",width:150,},
          {headerName: "Website", field: "website",width:200,
          cellRenderer: function (params){
            let website = params.data.website;
            let newLink = `<a href= ${website} target="_blank">${website}</a>`;
            console.log(newLink)
            return newLink;
          }},
        ],
        rowData: null
      },
      gridApi: null,
      columnApi: null,
    };
  },
  computed:{
    console: () => console,
    windows: () => window,
  },
  methods: {
    loadNews(){
      getNews(0).then(response => {
        // this.gridOptions.rowData = response.data
        // console.log(this.gridOptions.rowData)
        this.gridApi.setRowData(response.data)
      })
    },
    onGridReady(params){
      this.gridApi = params.api;
      this.gridColumnApi = params.columnApi;
    }
  },
  created() {
    this.loadNews()
  }
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