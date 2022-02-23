const checkThatTwoPlusTwoEqualsFourAMillionTimes = () => {
    for(let i = 1; i <= 1000000; i++) {
      if ( (2 + 2) != 4) {
        console.log('Something has gone very wrong :( ');
      }
    }
  };
  
  const addTwo = num => num + 2;
  
  const timeFuncRuntime = funcParameter => {
    let t1 = Date.now();
    funcParameter();
    let t2 = Date.now();
    return t2 - t1;
  };
  
  // Write your code below
  const time2p2 = timeFuncRuntime(addTwo);
  
  function checkConsistentOutput(func, value){
    if (func(value) === func(value))
        return func(value);
      return 'This function returned inconsistent results';
  }
  
  console.log(checkConsistentOutput(addTwo, 6));
  
  