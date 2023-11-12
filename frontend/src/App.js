import 'bootstrap/dist/css/bootstrap.min.css';
import { icons } from './icons';
import styled from 'styled-components';
import { prepareCards } from './utils/prepareCards';
import CardsTable from './CardsTable'
import { useEffect, useState } from 'react';
import { Reload } from './icons';

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

const H = styled.h1`
  font-size: 40px;
`;

const HeaderContainer = styled.div`
  min-width: 800px;
  display: flex;
  justify-content: space-evenly ;
  align-items: center;
`;
const ResetButton = styled.div`
  svg {
    width: 30px;
    height: 30px;
    fill: #212529
  }
  padding-bottom: 10px;
  
  cursor: pointer;
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
        <ResetButton onClick={() => handleReset()}><Reload /></ResetButton>
      </HeaderContainer>
      <CardContainer>
        <CardsTable handleSetTurns={setTurnsCount} icons={preparedIcons} />
      </CardContainer>
    </Container>
  );
}

export default App;
