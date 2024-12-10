<script setup>
import {pageType} from "@/router/index.js";
import {computed} from "vue";

const props = defineProps({
  to: String,
  pagePath: String,
  activePagePath: String
});

const isActive = computed(() => (props.pagePath === props.activePagePath));
</script>

<template>
  <router-link :to="to" :class="{'navigation-container__button--active': isActive, 'navigation-container__button': true}">{{ pageType[pagePath] }}</router-link>
</template>

<style scoped>

</style>