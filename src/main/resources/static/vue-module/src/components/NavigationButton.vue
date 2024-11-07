<script setup>
import {pageType} from "@/router/index.js";
import {computed} from "vue";

const props = defineProps({
  to: String,
  pagePath: String,
  activePagePath: String
});

const isActive = computed(() => (props.pagePath === props.activePagePath));
const iconPath = computed(() => `/images/${props.pagePath}_${isActive.value ? 'enabled' : 'disabled'}.png`);
</script>

<template>
  <router-link :to="to" :class="{'header-container__nav-button--active': isActive, 'header-container__nav-button': true}">
    <img :src="iconPath" alt="nav-icon" />{{ pageType[pagePath] }}</router-link>
</template>

<style scoped>

</style>