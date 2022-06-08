Vue.createApp({
  data() {
    return {
        article: {
            articleId: 0,
            title: '',
            excerpt: '',
            content: '',
            category: {
                name: '',
                categoryId: 0
            },
            author: {
                firstName: '',
                lastName: '',
                authorId: 0
            },
            date: ''
        },
        articles: []
    }
},
    methods: {
      random(){
        alert("clicked")
      }
      
    },
    mounted: function () {
      axios
          .get("http://localhost:8080/article/getAll")
          .then(response => this.articles = response.data)
          //.then(response => console.log(response))
          .catch(function (error) {
              console.log(error)
              alert("Napaka pri izpisu člankov.")
          })

  }
}).mount("#articles")
