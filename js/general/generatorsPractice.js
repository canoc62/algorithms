const fetch = require('isomorphic-fetch');

function* gen() {
  const uri = 'https://jsonplaceholder.typicode.com/posts/1';
  const response = yield fetch(uri);
  //console.log('response: ', response);
  const post = yield response.json();
  const title = post.title;
  //console.log('Title: ', title);
  yield
}

function run(generator) {
  const iterator = generator();

  const promise = iterator.next().value;
  promise.then((val) => {
    const promise2 = iterator.next(val).value;
    //console.log(promise2);
    promise2.then((data) => {
      //console.log(data);
      iterator.next(data);
    });
  });
}

run(gen);