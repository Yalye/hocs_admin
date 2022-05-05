<template>
  <b-button> add new webiste </b-button>
  <el-button @click="editRow">add</el-button>
  <div class="WebsiteTable">
    <ag-grid-vue
        class="ag-theme-alpine"
        :columnDefs="gridOptions.columnDefs"
        @grid-ready="onGridReady"
        :rowData="gridOptions.rowData"
        :pagination=true
        :paginationPageSize=10
    >
    </ag-grid-vue>  </div>
</template>


<script>
import "ag-grid-community/dist/styles/ag-grid.css";
import "ag-grid-community/dist/styles/ag-theme-alpine.css";
import { AgGridVue } from "ag-grid-vue3";
import { sidebarWidth } from '@/components/sidebar/state'
import {getWebsites} from "@/services/NewsApi";

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
          {headerName: "url", field: "url",width:500,
            cellRenderer: function (params) {
              let url = params.data.url;
              let newLink = `<a href= ${url} target="_blank">${url}</a>`;
              console.log(newLink)
              return newLink;
            },
            resizable: true
          },
          {headerName: "Description", field: "desc",width:150,},
          {headerName: "xpath", field: "xpath",width:150,},
          {headerName: "Special Domain", field: "specialDomain",width:150,},
          {headerName: "Proxy", field: "usingProxy",width:150,},
          {headerName: "Add Time", field: "addTime",width:200}
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
    loadWebsites(){
      getWebsites().then(response => {
        // this.gridOptions.rowData = response.data
        // console.log(this.gridOptions.rowData)
        this.gridApi.setRowData(response.data)
      })
    },
    onGridReady(params){
      this.gridApi = params.api;
      this.gridColumnApi = params.columnApi;
    },
    // eslint-disable-next-line no-unused-vars
    editRow(operation, row){
      operation = 1;
      row = 2;
    }
  },
  created() {
    this.loadWebsites()
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