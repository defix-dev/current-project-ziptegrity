<script setup>
import NavigationButton from "@/components/NavigationButton.vue";
const props = defineProps({
  pagePath: String
});
</script>

<template>
  <div class="header-container__navigation-container">
    <NavigationButton to="/services/chat" :activePagePath="pagePath" pagePath="chat"/>
    <NavigationButton to="/services/currency_converter" :activePagePath="pagePath" pagePath="currency_converter"/>
    <NavigationButton to="/services/calculator" :activePagePath="pagePath" pagePath="calculator"/>
    <NavigationButton to="/services/weather" :activePagePath="pagePath" pagePath="weather"/>
  </div>
</template>

<style scoped>

</style>