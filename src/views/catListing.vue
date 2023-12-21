<script setup>
import { ref, onBeforeMount } from "vue";
import ListCategory from '../components/listCategory.vue'

const eventList = ref([])
const getEventList = async () => {
  const res = await fetch(`${import.meta.env.VITE_BASE_URL}/events`)
  if (res.status === 200) {
    eventList.value = await res.json();
  } else {
    console.log("No Scheduled Events");
  }
};

const categoryList = ref([])
const getCategory = async () => {
  const res = await fetch(`${import.meta.env.VITE_BASE_URL}/eventCategories`)
  if (res.status === 200) {
    categoryList.value = await res.json(); 
  } else {
    console.log("No Category");
  }
};
onBeforeMount(async () => {
  await getCategory();
  await getEventList();
});

const selectedCat = ref({})
const checkCat = (e) =>  eventList.forEach(event => e.id === event.eventCategory.id)? selectedCat.value = e : []


</script>
 
<template>
    <div class="app">
      <div id="allCategory">
        <h1 id="categoryTitle">Category</h1>
        <ListCategory id="listCate" :categories="categoryList" @selectCat="selectedCat"/>
      </div> 
    </div>
</template>
 
<style lang="scss" scoped>
#categoryTitle{
  position: absolute;
  font-weight: bold;
  left:1100px;
  top:50px;
  font-size:70px;
  color: white;
}
#allCategory{
margin-top: 130px;
margin-left: 150px;
font-size: 25px;
}
#listCate{
  padding-left: 50px;
}
</style>