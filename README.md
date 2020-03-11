#Countries Info App
==================================
<img src ="https://github.com/douglasalipio/graphql_countryinfo_sample/blob/master/app/main_view.gif" width="360" />&nbsp;&nbsp;

It's a simple application to show the basic understanding of GraphQL in Android. The App is able to show information about a specific country selected by the user.

### GraphQL query

Fetch information related to the country that user has selected.
Here's the query responsable to fetch all information of the country.

```graphql
query GetCountriesInfo($nameSelected : String){
	country(code: $nameSelected) {
		name
		native
		emoji
		states{
			name
		}
		currency
		languages {
			code
			name
		}
		continent{
			name
		}
	}
}
```
### Architecture

<img src ="https://github.com/douglasalipio/graphql_countryinfo_sample/blob/master/architecture_diagram.png"/>&nbsp;&nbsp;

The MPV design pattern has been implemented to make views reusable and to isolate business rules from the View layer, which makes it easier to test. The application is divided into three layers, namely View, Presenter, and Data. In addition, there is an interactor responsible to fetch the country information.

### Relevant 3rd party libraries

- ApolloClient
- RxJava2
- Groupie
- Gson
- Espresso
- Mockito
- Junit4 

### Instalation

Android Studio 3.6.1
Gradle 5.6.4
