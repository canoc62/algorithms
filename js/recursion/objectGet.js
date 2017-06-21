// Create the lodash get method
// var x = { 'foo' : 'foo-x' };
// get(x, ‘foo’, ‘default’) // -> ‘foo-x’ 
// get(x, ‘bar’, ‘default’) // -> ‘default’

// Now make it work for:
 //var x = { 'foo': { 'bar': 'hello' } };
// get(x, ‘foo.bar’, ‘default’); // ‘hello’
// var x = { 'foo': ['cs', { 'bar': 'world' }, 'test'] };
// get(x, ‘foo.1.bar’, ‘default’); // ‘world’


function get(object, path, def) {
  
  const paths = Array.isArray(path) ? path: path.split('.');
  
  console.log('PATHS: ', paths);
  function recurse(value, paths) {
    // if (Array.isArray(value) && value.length === 1) {
    //   // console.log('value before transformation: ', value);
    //   value = value[0];
    // }
    // console.log('value: ', value);
    // console.log('paths[0]: ', paths[0]);
    let currPath = paths[0];
    if (currPath && currPath.includes('[')) {
      // console.log('in includes if');
      const bracketIndex = currPath.indexOf('[');
      const firstKey = currPath.substring(0, bracketIndex);
      // console.log('firstKey: ', firstKey);
      const restOfPath = currPath.slice(bracketIndex);
      // console.log('restOfPath: ', restOfPath);
      currPath = `[\'${firstKey}\']${restOfPath}`;
      // console.log('new currPath: ', currPath);
      // console.log('the value: ', value);
      // console.log('value[currPath]: ', value[currPath]);
      return recurse(eval(`value${currPath}`), paths.slice(1));
    }
    
    
    if (!currPath) return value;
    //console.log('value[currPath]: ', value[currPath]);
    return recurse(value[currPath], paths.slice(1));
  }
  
  return recurse(object, paths) || def;
}

var x = { 'foo': ['cs', { 'bar': 'world' }, 'test'] };
console.log(get(x, 'foo[1][\'bar\']', 'default'));
console.log(get(x, 'foo.1.bar', 'default'));

var object = { 'a': [{ 'b': { 'c': 3 } }, { 'g': { 'd': 10 } }] };
console.log(get(object, 'a[0].b[\'c\']'));
//console.log(get(object, 'a[0].b.c'));
//console.log(get(object, 'a.b[\'c\']'));
console.log(get(object, 'a[1].g.d'));



// Clean without console logs
function get(object, path, def) {
  
  const paths = Array.isArray(path) ? path: path.split('.');
  
  // console.log('PATHS: ', paths);
  function recurse(value, paths) {
    let currPath = paths[0];
    if (currPath && currPath.includes('[')) {
      const bracketIndex = currPath.indexOf('[');
      const firstKey = currPath.substring(0, bracketIndex);
      const restOfPath = currPath.slice(bracketIndex);
      currPath = `[\'${firstKey}\']${restOfPath}`;
      return recurse(eval(`value${currPath}`), paths.slice(1));
    }
    
    
    if (!currPath) return value;
    return recurse(value[currPath], paths.slice(1));
  }
  
  return recurse(object, paths) || def;
}