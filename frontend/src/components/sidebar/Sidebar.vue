<script>
import SidebarLink from './SidebarLink'
import { collapsed, toggleSidebar, sidebarWidth } from './state'

export default {
  props: {},
  components: { SidebarLink },
  setup() {
    return { collapsed, toggleSidebar, sidebarWidth }
  }
}
</script>

<template>
  <div class="sidebar" :style="{ width: sidebarWidth }">
    <h1>
      <span v-if="collapsed">
        <div>C</div>
        <div>H</div>
      </span>
      <div v-else class="top-left-title">
        <div>Computer</div>
        <div>History</div>
      </div>
    </h1>

    <SidebarLink to="/news" icon="fas fa-home">All News</SidebarLink>
    <SidebarLink to="/websites" icon="fas fa-columns">Websites</SidebarLink>
    <SidebarLink to="/analytics" icon="fas fa-chart-bar">Statistics</SidebarLink>
    <SidebarLink to="/people" icon="fas fa-image">People</SidebarLink>
    <SidebarLink to="/about" icon="fas fa-image">About</SidebarLink>

    <span
        class="collapse-icon"
        :class="{ 'rotate-180': collapsed }"
        @click="toggleSidebar"
    >
      <i class="fas fa-angle-double-left" />
    </span>
  </div>
</template>

<style>
:root {
  --sidebar-bg-color: #2f855a;
  --sidebar-item-hover: #38a169;
  --sidebar-item-active: #276749;
}

.top-left-title{
  font-size: medium;
}
</style>
<style scoped>
.sidebar {
  color: white;
  background-color: var(--sidebar-bg-color);

  float: left;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  bottom: 0;
  padding: 0.5em;

  transition: 0.3s ease;

  display: flex;
  flex-direction: column;
}

.sidebar h1 {
  height: 2.5em;
}

.collapse-icon {
  position: absolute;
  bottom: 0;
  padding: 0.75em;

  color: rgba(255, 255, 255, 0.7);

  transition: 0.2s linear;
}

.rotate-180 {
  transform: rotate(180deg);
  transition: 0.2s linear;
}
</style>
