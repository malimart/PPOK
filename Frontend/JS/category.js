Vue.createApp({
  data() {
      return {
          category: {
              name: '',
              categoryId: 0
          },
          categories: []
      }
  },
  methods: {
      getAllCategories() {
          axios
          .get("http://localhost:8080/category/getAll")
          .then(response => this.categories = response.data)
          .catch(function (error) {
              console.log(error)
              alert("Napaka pri izpisu kategorij.")
          })
      },
      addCategory() {
          axios
              .post("http://localhost:8080/category/save", this.category)
              .then(response => { console.log(response)
                  this.getAllCategories()
              })
              .catch(function (error) {
                  console.log(error)
                  alert("Napaka pri shranjevanju kategorije.")
              })
      },
      findCategory() {
          axios
              .get("http://localhost:8080/category/findBytName/" + this.category.name)
              .then(response => this.categories = response.data)
              .catch(function (error) {
                  console.log(error)
                  alert("Napaka pri iskanju.")
              })
      },
      updateCategory() {
          axios
              .put("http://localhost:8080/category/update", this.category)
              .then(response => {console.log(response)
                  this.getAllCategories()
              })
              .catch(function (error) {
                  console.log(error)
                  alert("Ni možno posodobiti podatkov.")
              })
      },
      deleteCategory(cid) {
          axios
              .delete("http://localhost:8080/category/delete/" + cid)
              .then(response => {console.log(response)
                  this.getAllCategories()
              })
              .catch(function (error) {
                  console.log(error)
                  alert("Ni možno izbrisati kategorije.")
              })
      }
  },
  mounted: function () {
      axios
          .get("http://localhost:8080/category/getAll")
          .then(response => this.categories = response.data)
          .catch(function (error) {
              console.log(error)
              alert("Napaka pri izpisu kategorij.")
          })

  }
}).mount("#category")
