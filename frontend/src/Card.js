import { useState } from 'react';
import styled from 'styled-components';

const Wrapper = styled.div`
  svg {
    width: 60px;
    height: 60px;
  }
  position: relative;
  display: grid;
  place-items: center;
  background-color: ${({ color }) => color || '#f0f0f0'};
  width: 100px;
  height: 100px;
  padding: 16px;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  cursor: pointer;
   perspective: 1000px;
  transform-style: preserve-3d;
  transition: transform 0.5s;
  transform: ${({ $isFlipped }) => ($isFlipped ? 'rotateY(180deg)' : 'rotateY(0)')};
`;

const CardFront = styled.div`
  transform: rotateY(180deg);
  position: absolute;
  backface-visibility: hidden;
`;

const CardBack = styled.div`
  transform: rotateY(0deg);
  background-color: '#3498db';
  background-image: linear-gradient(160deg, #0093e9 0%, #80d0c7 100%);
`;

const Card = ({ icon, color, name, id, onClick, matched, flipped }) => {
  const [isFlipped, setFlipped] = useState(matched);

  const handleClick = (name, id, matched) => {
    if (matched) {
      setFlipped(true);
      return;
    }
    setFlipped(!isFlipped);
    onClick(name, id, matched);
  };

  return (
    <Wrapper $isFlipped={flipped} onClick={() => handleClick(name, id, matched)} color={color}>
      <CardFront>{icon}</CardFront>
      <CardBack></CardBack>
    </Wrapper>
  )
};

export default Card;