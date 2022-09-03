<template>
  <div>
<!--  <b-button> add new</b-button>-->
  <el-button @click="showAddWindow" type="primary">add</el-button>
    <div class="searchBar">
    <!-- Filter Search -->
    <div class="input-group mb-5">
      <input type="search" class="form-control" v-model='searchQuery' placeholder="Student's Name" aria-label="Recipient's username" aria-describedby="button-addon2">
    </div>
  </div>
  </div>
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
  <div id="add_dialog" title="新增网站" style="display: block">
    <form>
      <p> 网站链接： <input type="text" id="adding_site_url"/></p>
      <p> 网站作者： <input type="text" id="adding_site_author"/></p>
      <p> 解析xpath： <input type="text" id="adding_site_xpath"/></p>
      <p> 网址前缀： <input type="text" id="adding_site_prefix"/></p>

      <div style="float: right">
        <b-button onclick="">取消</b-button>
        <b-button onclick="addWebsite">保存</b-button>
      </div>
    </form>
  </div>
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
    },
    showAddWindow(){
      document.getElementById("add_dialog").style.display="block";
    },
    addWebsite(){
      var site_url = document.getElementById("adding_site_url").value;
      console.log(site_url)

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

#add_dialog{
  /*float: right;*/
  position: absolute;
  right: 200px;
  top: 200px;
  width: 300px;
  height: 100px;
}

</style>