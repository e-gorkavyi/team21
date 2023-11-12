import 'bootstrap/dist/css/bootstrap.min.css';
import { icons } from './icons';
import styled from 'styled-components';
import { prepareCards } from './utils/prepareCards';
import CardsTable from './CardsTable'
import { useEffect, useState } from 'react'

const Container = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  height: 100vh; 
  background-color: gray;
`;

const CardContainer = styled.div`
  display: grid;
  grid-template-rows: repeat(4, 1fr);
  grid-template-columns: repeat(4, 1fr);
  gap: 8px;
`;

const H = styled.div`
  /* margin-right: 270px; */
  font-size: 40px;
`;

const HeaderContainer = styled.div`
  display: flex;
  justify-content: space-evenly ;
  align-items: center;
`;
const ResetButton = styled.button`
  width: 50px;
  height: 50px;
`;

function App() {
  const [turnsCount, setTurnsCount] = useState(0);
  const [preparedIcons, setPreparedIcons] = useState(prepareCards(icons));

  const handleReset = () => {
    setTurnsCount(0);
    setPreparedIcons(prepareCards(icons));
  }

  return (
    <Container>
      <HeaderContainer>
        <H>Moves: {turnsCount}</H>
        <ResetButton onClick={() => handleReset()}>Reset</ResetButton>
      </HeaderContainer>
      <CardContainer>
        <CardsTable handleSetTurns={setTurnsCount} icons={preparedIcons} />
      </CardContainer>
    </Container>
  );
}

export default App;
