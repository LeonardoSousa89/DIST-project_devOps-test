import { BrowserRouter, Routes, Route } from 'react-router-dom'

import Insert from '../pages/insert'
import GetById from '../pages/getById'
import Search from '../pages/search';
import Account from '../pages/creat-account';


function App() {
  return (
   <BrowserRouter>
        <Routes>
            <Route exact={true} path="/" element={<Account/>} />
            <Route exact={true} path="/insert" element={<Insert/>} />
            <Route exact={true} path="/search" element={<Search/>} />
            <Route exact={true} path="/get-by-id" element={<GetById/>} />
            <Route exact path="*" element={<Account/>} />
        </Routes>
   </BrowserRouter>
  );
}

export default App;
